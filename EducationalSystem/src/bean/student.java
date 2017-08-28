package bean;

import java.sql.*;

public class student {
	private String sname;
	private String sid;
	private String spassword;
	private String sclass;
	private String smajor;
	public String getSname(){
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}	
	
	public ResultSet getStudent(){
		String sql="select * from student";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;		
	} 
	public ResultSet getSname(String s_id){
		String sql="select sname from student where id='"+s_id+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getSmajor(String s_id){
		String sql="select smajor from student where id='"+s_id+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getSnameId(String sclass){
		String sql="select id,sname,from student where sclass='"+sclass+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public boolean haslogin(String sid){
		boolean f = true;
		String sql = "select id from student where id='"+sid+"'";
		sqlBean db = new sqlBean();
		try{
			ResultSet rs = db.executeQuery(sql);
			if(rs.next()){
				f=true;
			}else {
				f = false;
			}
		}catch(Exception e){
			e.getMessage();
		}
		return f;
	}
	public void addStudent(){
		String sql="insert into student(id,sname,password,sclass,smajor) values ('"
			+sid+"','"+sname+"','"+spassword+"','"+sclass+"','"+smajor+"')";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public int deleteStudent(String id){
	    int num = 0;
	    String sql="delete from student where id ='"+id+"' ";
	    sqlBean db= new sqlBean();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void updateStudent(){
		String sql="update student "+" set sname='"+sname+"',"+" password='"+spassword
		+"' "+" where id='"+sid+"'";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}

}
