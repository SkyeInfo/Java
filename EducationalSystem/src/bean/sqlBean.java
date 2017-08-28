package bean;
import java.sql.*;
public class sqlBean {
	public Connection conn=null;
	public ResultSet rs=null;
	Statement st=null;

	public sqlBean(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/stu_score_ms?user=root&password=root&useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url);
			st=conn.createStatement(1004,1008);
		}
		catch(ClassNotFoundException e){
			System.err.println("�����������д���:"+e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int executeInsert(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("ִ�в����д���:"+e.getMessage());
		}
		return num;
	}
	public ResultSet executeQuery(String sql){
		rs=null;
		try{
			rs=st.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("ִ�в�ѯ�д���:"+e.getMessage());
		}
		return rs;
	}
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			System.err.println("ִ���޸��д���"+ex.getMessage());
		}
		return num;
	}
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("Delete Failed"+e.getMessage());
		}
		CloseDataBase();
		return num;
	}
	public void CloseDataBase(){
		try{
			conn.close();
			st.close();
		}
		catch(Exception ex){
			System.err.println("Connection Failed"+ex.getMessage());
		}
	}

}
