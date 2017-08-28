package bean;

import java.sql.*;

public class studentcourse {
	private String sid;
	private String cid;
	private String cname;
	private double credit;
	private int capacity;
	private String clnum;
//	private String time;
	
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getClnum() {
		return clnum;
	}

	public void setClnum(String clnum) {
		this.clnum = clnum;
	}

/*	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}*/

	public ResultSet getstucouone(String s_id){
		String sql="select * from studentcourse where sid='"+s_id+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public void addstucourse(){
		String sql1="insert into studentcourse(sid,cid,cname,credit,capacity,clnum) values ('"+sid+"','"+cid+"','"+cname+"','"+credit+"','"+capacity+"','"+clnum+"')";
		String sql2="insert into score(sid,cid,cname,credit) values ('"+sid+"','"+cid+"','"+cname+"','"+credit+"')";
        sqlBean db=new sqlBean();
        db.executeInsert(sql1);
        db.executeInsert(sql2);
	}
    
        public ResultSet getStucourse(){
    		String sql="select * from studentcourse";
    		sqlBean db=new sqlBean();
    		ResultSet rs=db.executeQuery(sql);
    		return rs;
    	}
    	public ResultSet getStuCou(String cno,String clnum){
    		String sql="select studentcourse.sid,student.sname, studentcourse.cname,studentcourse.credit from student,studentcourse where (studentcourse.sid=student.id and cno='"+cno+"' and clnum='"+clnum+"')";
    		sqlBean db=new sqlBean();
    		ResultSet rs=db.executeQuery(sql);
    		return rs;
    	}
    	
    	public boolean isValid(String sid,String cno){
    		boolean f=true;
    		String sql="select sid from studentcourse where (sid='"+sid+"' and cid='"+cno+"')";
    		sqlBean db=new sqlBean();	
    		try{
    			ResultSet rs=db.executeQuery(sql);
    			if(rs.next()) 
    				f=true;
    			else 
    				f=false;
    		}
    		catch(Exception e){e.getMessage();}
    		return f;
    	}
    	public int deleteStucou(String sid,String cno){
    		int num=0;
    		String sql="delete from studentcourse where (sid='"+sid+"' and cid='"+cno+"')";
    	    sqlBean db=new sqlBean();
    	    num=db.executeDelete(sql);
    	    return num;
    	}

		public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

}
