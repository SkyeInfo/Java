package Meetingrmi;

import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.SQLException;

public class Client
{
	static String userName;
	static String password;
	static String schedule_user;
	static String title; static String label;
	static String startTime; static String endTime;
	static int meetingID;
	private static int PORT = 8099;

	public static void main(String[] args)
	{

		System.out.println("���ڡ�Client������������");
		System.out.println("�����б�");
		System.out.println("-r register  ע���û�");
		System.out.println("-a add  ��ӻ���");
		System.out.println("-q query  ��ѯ��ػ���");
		System.out.println("-d delete  ɾ����ػ���");
		System.out.println("-c clear  ���ĳԤԼ�˵����л���");
		System.out.println("end  ��������");
		args = new String[100];
		args[0]="start";

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String registryURL = "rmi://localhost:"+PORT+"/RMIServer";
		ServiceInterface service = null;
		try {
			service = (ServiceInterface)Naming.lookup(registryURL);
			Scanner scan = new Scanner(System.in);
			while(!args[0].equals("end")){
				System.out.println("��������������磺 -a��");
				args[0]=scan.nextLine();

				if(args[0].equals("-r"))
				{
					System.out.print("�������û���: ");
					userName = scan.nextLine();
					System.out.print("����������: ");
					password = scan.nextLine();
					if (service.register(userName, password)) {
						System.out.println("ע��ɹ���");
					}else{
						System.out.println("ע��ʧ�ܣ�����ʹ�õ��û����Ѿ����ڣ�");
					}
				}

				else if(args[0].equals("-a"))
				{

					System.out.println("����������ԤԼ�ˡ����롢�����λ��ˡ��������⡢��ǩ����ʼʱ�����ֹʱ�䣬�ûس����ָ���");
					userName = scan.nextLine(); password = scan.nextLine();
					schedule_user = scan.nextLine(); title = scan.nextLine();
					label = scan.nextLine(); startTime = scan.nextLine();
					endTime = scan.nextLine();
					if (service.add(userName, password, schedule_user, title, label, startTime,endTime)) {
						System.out.println("ԤԼ�ɹ���");
					}
					else {
						System.out.println("ԤԼʧ�ܣ����飺");
						System.out.println("1�����Ƿ���ע��");
						System.out.println("2�������������λ������л��鰲��");
						System.out.println("3������ʱ���Ƿ���ڳ�ͻ");
					}
				}

				else if(args[0].equals("-q"))
				{
					System.out.println("�����������ѯ�ˡ���ʼʱ�����ֹʱ�䣬�ûس����ָ���");
					userName = scan.nextLine();
					startTime = scan.nextLine();
					endTime = scan.nextLine();
					String[] queryresult= new String[100];
					queryresult = service.query(userName,startTime,endTime);

					if(queryresult.length>=1&&queryresult[0] != null){
						for(int i=0;i<queryresult.length;i++){
							if(queryresult[i] != null){
								System.out.println(queryresult[i]);
							}
						}
					}
					else
					{System.out.println("δ��ѯ����ػ�����Ϣ��");}
				}

				else if(args[0].equals("-d"))
				{

					System.out.println("����������ԤԼ�˺ͻ���ID���ûس����ָ���");
					userName = scan.nextLine();
					meetingID = scan.nextInt();
					if(service.delete(userName,meetingID))
						System.out.println("ɾ���ɹ���");
					else
						System.out.println("����ԤԼ�˻����ID�Ƿ���������");
				}
				else if(args[0].equals("-c"))
				{

					System.out.println("������ԤԼ�ˣ�");
					userName = scan.nextLine();
					if(service.clear(userName)){
						System.out.println("�����ɣ�");}
					else {
						System.out.println("����ʧ�ܣ�");
					}

				}
				else
				{System.out.println("�Ƿ����");}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
