package Meetingrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class ServiceImpl extends UnicastRemoteObject implements ServiceInterface {

	public java.sql.Connection conn = null;
	public java.sql.ResultSet rs = null;
	java.sql.Statement st=null;
	java.sql.Statement st1=null;
	java.sql.Statement st2=null;
	java.sql.Statement st3=null;
	java.sql.Statement st4=null;
	java.sql.Statement st5=null;
	java.sql.Statement st6=null;
	java.sql.Statement st7=null;
	java.sql.Statement st8=null;
	java.sql.Statement st9=null;
	ResultSet a,b,c,d,e,f,g,h,i,j;
	public ServiceImpl() throws RemoteException {
		try {
			//ע������
			//com.microsoft.sqlserver.jdbc.SQLServerDriver
			//Class.forName("org.objectweb.rmijdbc.Driver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			//�������ݿ�����
			String url = "jdbc:sqlserver://localhost:1433;"+"DatabaseName=MeetingManager;UserName = sa;PassWord = 123";
			//����ִ�ж���
			conn = DriverManager.getConnection(url);
			st = conn.createStatement();
			st1 = conn.createStatement();
			st2 = conn.createStatement();
			st3 = conn.createStatement();
			st4 = conn.createStatement();
			st5 = conn.createStatement();
			st6 = conn.createStatement();
			st7 = conn.createStatement();
			st8 = conn.createStatement();
			st9 = conn.createStatement();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int register(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){}
		return num;
	}
	public ResultSet query(String sql){
		rs=null;
		try{
			rs=st.executeQuery(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public int add(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException e){}
		return num;
	}
	public int delete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){}
		//CloseDataBase();
		return num;
	}
	public int clearAll(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){}
		//CloseDataBase();
		return num;
	}
	public void CloseDataBase(){
		try{
			conn.close();
			st.close();
		}
		catch(Exception e){}
	}
	// add a meeting
	@Override
	public boolean add(String userName, String password, String schedule_user,
					   String title, String label, String startTime, String endTime) throws RemoteException {

		boolean flag = false;
		boolean flag1=true;
		boolean flag2=true;
		int meetingID = 0;
		int rowCount=0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse(startTime);
			endDate = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			a=st.executeQuery("select * from userinfo where userName='"+userName+"'");
			j=st9.executeQuery("select * from userinfo where userName='"+schedule_user+"'");
			if (a.next()&&j.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// judge if user& schedule user have other meeting
		try {
			b=st1.executeQuery("select * from meeting where userName='"+userName+"'");
			c=st2.executeQuery("select * from meeting where schedule_user='"+schedule_user+"'");
			while(b.next()){
				String StartString=b.getString(6);

				String EndString=b.getString(7);

				Date StartDate = sdf.parse(StartString);
				Date EndDate = sdf.parse(EndString);

				if((startDate.getTime()<=StartDate.getTime()&&endDate.getTime()>=StartDate.getTime())||
						(startDate.getTime()<=EndDate.getTime()&&endDate.getTime()>=EndDate.getTime())){
					System.out.println("ԤԼ�˵�ʱ���г�ͻ��");//��user��ʱ���ͻ
					flag1=false;
					break;
				}
			}
			while(c.next()){
				String schedule_StartString=c.getString(6);
				String schedule_EndString=c.getString(7);
				Date schedule_StartDate = sdf.parse(schedule_StartString);
				Date schedule_EndDate = sdf.parse(schedule_EndString);
				if((startDate.getTime()<=schedule_StartDate.getTime()&&endDate.getTime()>=schedule_StartDate.getTime())||
						(startDate.getTime()<=schedule_EndDate.getTime()&&endDate.getTime()>=schedule_EndDate.getTime()))
				{
					System.out.println("�λ��ߵ�ʱ���г�ͻ��");//��anotherUser��ʱ���ͻ
					flag2=false;
					break;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag&&flag1&&flag2){
			try {
				i=st8.executeQuery("select * from meeting");
				while(i.next())
				{
					rowCount++;
				}
				meetingID=rowCount+1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String sql = "insert into meeting(meetingID,userName,schedule_user,title,label,startTime,endTime) values("
					+meetingID+",'"+userName+"','"+schedule_user+"','"+title+"','"+label+"','"+startTime+"','"+endTime+"')";
			add(sql);

			System.out.println("���ӻ���ɹ�������ID��" + meetingID);

			return true;
		}
		else{
			System.out.println("�ͻ���δԤԼ�����ʱ���ͻ��");
			return false;
		}
	}

	// clean all
	@Override
	public boolean clear(String userName) throws RemoteException {

		boolean flag = false;
		try {
			d=st3.executeQuery("select * from userinfo where userName='"+userName+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (d.next()) {
				System.out.println("��������ע�ᣡ");
				flag = true;
			}
		} catch (SQLException e) {e.printStackTrace();}
		if (flag) {
			String sql="delete from meeting where userName='"+userName+"'";
			clearAll(sql);
			System.out.println(userName+"�����Ļ����ѱ������");
			return true;
		}
		else {
			System.out.println("������δע�ᣡ");
			return false;
		}
	}

	//delete a meeting
	public boolean delete(String userName, int meetingID) throws RemoteException, SQLException {

		boolean flag = false;
		try {
			e=st4.executeQuery("select * from userinfo where userName='"+userName+"'");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (e.next()) {
				System.out.println("��������ע�ᣡ");
				flag = true;
			}
		} catch (SQLException e) {e.printStackTrace();}

		if (flag) {
			String sql="delete from meeting where userName='"+userName+"' and meetingID='"+meetingID+"'";
			delete(sql);
			System.out.println(userName+"������IDΪ"+meetingID+"�Ļ����ѱ������");
			return true;
		}
		else {
			System.out.println("������δע����������");
			return false;}
	}

	//query meeting
	@Override
	public String[] query(String userName, String start, String end) throws RemoteException,SQLException {

		boolean flag = false;
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		try {
			f=st5.executeQuery("select * from userinfo where userName='"+userName+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String[] s = new String[100];

		if (f.next()) {
			System.out.println("��������ע�ᣡ");
			flag = true;
		}

		if (flag) {
			Date startDate = null;
			Date endDate = null;
			try {
				startDate = sdf.parse(start.trim());
				endDate = sdf.parse(end.trim());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql="select * from meeting where userName='"+userName+"'or schedule_user = '"+userName+"'and startTime>='"+startDate.toLocaleString()+"'  and endTime<='"+endDate.toLocaleString()+"'";
			try {
				g=st6.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i=0;
			while (g.next()) {
				s[i]="ID:"+g.getInt(1)+" �λ���:<"+g.getString(2)+"&"+g.getString(3)+"> "+"Title:"+g.getString(4)+" Label:"+g.getString(5);
				i++;
			}
			return s;
		}
		else{
			System.out.println("������δע�ᣡ");
			String[] err= new String[1];
			err[0]="��ѯʧ�ܣ������Ƿ���ע�ᣡ";
			return err;
		}
	}

	//register 
	@Override
	public boolean register(String userName, String password) throws RemoteException, SQLException {

		try {
			h=st7.executeQuery("select * from userinfo where userName='"+userName+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (h.next()) {
			System.out.println("�ͻ���ע��ʧ�ܣ�����ʹ�õ��û����Ѿ����ڣ�");
			return false;
		}

		else{
			String sql="insert into userinfo(userName,password) values ('"+userName+"','"+password+"')";
			register(sql);
			System.out.println("�ͻ���ע��ɹ���");
			return true;
		}
	}

}