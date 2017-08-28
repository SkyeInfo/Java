package bean;

import java.sql.*;

import bean.sqlBean;

public class course {
	private String cid;
	private String clnum;
	private String cname;
	private double credit;
	private int capacity;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getClnum() {
		return clnum;
	}
	public void setClnum(String clnum) {
		this.clnum = clnum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public ResultSet getCourse(){
		String sql="select * from course";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getCinfo(String cid){
	    String sql="select * from course where cid='"+cid+"'";
	    sqlBean db=new sqlBean();
	    ResultSet rs=db.executeQuery(sql);
	    return rs;
	}
	public boolean isValid(String cno){
		boolean f=true;
		String sql="select cid from course where cid='"+cno+"'";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){
				f=true;
			}
			else{
				f=false;
				}
		}
		catch(Exception e){
			e.getMessage();
		}
		return f;
		
	}
	public void addCourse(){
		String sql="insert into course(cid,clnum,cname,credit,capacity) values ('"+cid+"','"+clnum+"','"+cname+"',"+credit+","+capacity+")";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public int delcourse(String cno){
		int num=0;
		String sql="delete from course where cid='"+cno+"'";
		sqlBean db=new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
	public void updateCourse(){
		String sql="update course set cid='"+cid+"',clnum='"+clnum+"',cname='"+cname+"',credit="+credit+",capacity="+capacity
		+" where cid='"+cid+"'";
		sqlBean db=new sqlBean();
		db.Update(sql);
	}

}
