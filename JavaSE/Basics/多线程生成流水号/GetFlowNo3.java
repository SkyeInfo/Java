import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*写一个流水生成方法，长度12位，位数不足前补0.
 * 要求：1.通过多线程（5个线程）调用该方法，最终生成的流水号不能重复。
 *       2.生成1万个流水号，写入文本文件，写出的流水号不能重复。*/
class ShengChengFlowNo{ 
	private static final String SERIAL_NUMBER = "XXXX";
	private static String seqno=null;
	private ShengChengFlowNo(){}
	private static ShengChengFlowNo scfn = null;
	public static ShengChengFlowNo getInstance() {
		if (scfn == null) {
		synchronized (ShengChengFlowNo.class) {
			if (scfn == null) {
				scfn = new ShengChengFlowNo();
			}
		}
		}
		return scfn;
	}
	public synchronized String generaterNextNumber(String sno) {
		String id = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (sno == null) {
			id = sdf.format(date) + "0000";
		} else {
			int count = SERIAL_NUMBER.length(); 
			DecimalFormat df = new DecimalFormat("0000");
			String str=df.format(1 + Integer.parseInt(sno.substring(8, 12)));
			id = sdf.format(date) + str.substring(str.length()-4,str.length());
		}
		return id;
	}
	public synchronized String getFlowNo(){
		seqno = ShengChengFlowNo.getInstance().generaterNextNumber(seqno);
		return seqno;
	}
}

class FlowNo3 implements Runnable{
	
	File f = new File("D:\\1.txt");
	FileWriter fw = null;
	private void writeFile(String sss){
		try {
			fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sss + "\n");
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		for(int i=0;i<2000;i++){
			synchronized (f) {
				try {
					f.wait(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				String str = ShengChengFlowNo.getInstance().getFlowNo();
				System.out.println(Thread.currentThread().getName()+" : "+str);
				writeFile(Thread.currentThread().getName()+" : "+str);
			}
		}
	}
}
public class GetFlowNo3 {
	public static void main(String[] args) {
		FlowNo3 fn = new FlowNo3();
		 
		Thread th1 = new Thread(fn,"线程1");
		Thread th2 = new Thread(fn,"线程2");
		Thread th3 = new Thread(fn,"线程3");
		Thread th4 = new Thread(fn,"线程4");
		Thread th5 = new Thread(fn,"线程5");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}