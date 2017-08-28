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
		
		System.out.println("请在“Client”后面添加命令！");
		System.out.println("命令列表：");
		System.out.println("-r register  注册用户");
		System.out.println("-a add  添加会议");
		System.out.println("-q query  查询相关会议");
		System.out.println("-d delete  删除相关会议");
		System.out.println("-c clear  清除某预约人的所有会议");
		System.out.println("end  结束程序");
		args = new String[100];
		args[0]="start";

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String registryURL = "rmi://localhost:"+PORT+"/RMIServer";
		ServiceInterface service = null;
		try {
			service = (ServiceInterface)Naming.lookup(registryURL);
			Scanner scan = new Scanner(System.in);
		while(!args[0].equals("end")){
			System.out.println("请输入命令：（例如： -a）");
			args[0]=scan.nextLine();
			
			if(args[0].equals("-r"))
			{
				System.out.print("请输入用户名: ");
				  userName = scan.nextLine();
				  System.out.print("请输入密码: ");
				  password = scan.nextLine();
				  if (service.register(userName, password)) {
					  System.out.println("注册成功！");
				}else{
					System.out.println("注册失败！您所使用的用户名已经存在！");
					}
			}
			
			else if(args[0].equals("-a"))
			{
				
				System.out.println("请依次输入预约人、密码、其他参会人、会议主题、标签、起始时间和终止时间，用回车符分隔：");
				userName = scan.nextLine(); password = scan.nextLine();
				schedule_user = scan.nextLine(); title = scan.nextLine();
				label = scan.nextLine(); startTime = scan.nextLine();
				endTime = scan.nextLine();
				if (service.add(userName, password, schedule_user, title, label, startTime,endTime)) {
					System.out.println("预约成功！");
				}
				else {
					System.out.println("预约失败！请检查：");
					System.out.println("1、您是否已注册");
					System.out.println("2、您或者其他参会人已有会议安排");
					System.out.println("3、会议时间是否存在冲突");
				}
			}
				
			else if(args[0].equals("-q"))
			{
				System.out.println("请依次输入查询人、起始时间和终止时间，用回车符分隔：");
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
					{System.out.println("未查询到相关会议信息！");}
			}
			
			else if(args[0].equals("-d"))
			{
			
				System.out.println("请依次输入预约人和会议ID，用回车符分隔：");
				userName = scan.nextLine();
				meetingID = scan.nextInt();
				if(service.delete(userName,meetingID))
					System.out.println("删除成功！");
				else
					System.out.println("请检查预约人或会议ID是否输入有误！");
			}
			else if(args[0].equals("-c"))
			{

				System.out.println("请输入预约人：");
				userName = scan.nextLine();
				if(service.clear(userName)){
				System.out.println("清除完成！");}
				else {
					System.out.println("操作失败！");
				}
					
			}
			else
			{System.out.println("非法命令！");}
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
