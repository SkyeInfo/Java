
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new ImageViewerFrame();
				//给窗体命名
				frame.setTitle("图片查看器");
				//设置用户在此窗体上发起“close”时默认执行的操作
				//EXIT_ON_CLOSE 退出应用程序后的默认窗口关闭操作。一般用在应用程序中，不用在applet中
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//设置可见性
				frame.setVisible(true);
			}
		});
	}
}
class ImageViewerFrame extends JFrame{
	/**
	 * @author Skye
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	public ImageViewerFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		label = new JLabel();
		add(label);
		chooser = new JFileChooser();
		//设置过滤器，只显示jpg或者gif图像
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg","gif","png");
		chooser.setFileFilter(filter);
		JMenuBar meunBar = new JMenuBar();
		setJMenuBar(meunBar);

		JMenu meun = new JMenu("File");
		meunBar.add(meun);
		JMenuItem openItem = new JMenuItem("Open");
		meun.add(openItem);
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION){
					String name = chooser.getSelectedFile().getPath();
					ImageIcon ii = new ImageIcon(name);
					Image img = ii.getImage();
					img = img.getScaledInstance(1280,720, Image.SCALE_DEFAULT);
					label.setIcon(new ImageIcon(img));
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		meun.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}
}


