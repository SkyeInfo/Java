package bean;

import java.sql.ResultSet;

public class coursescore {
	private String cid;
	private String cname;
	private double credit;
	private String sid;
	private int pscore;
	private int qscore;
	private int grade;
	private double jpa;
	private double averagepoint;
	public double getAveragepoint(){
		return averagepoint;
	}
	public void setAveragepoint(double averagepoint) {
		this.averagepoint = averagepoint;
	}
	public double getJpa() {
		return jpa;
	}
	public void setJpa(double jpa) {
		this.jpa = jpa;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
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
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getPscore() {
		return pscore;
	}
	public void setPscore(int pscore) {
		this.pscore = pscore;
	}
	public int getQscore() {
		return qscore;
	}
	public void setQscore(int qscore) {
		this.qscore = qscore;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public ResultSet getScore(){
		String sql="select * from score";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public boolean hasLogin(String cid){
	  	boolean f=true;
	    String sql="select cid from score where cid ='"+cid+"'";
	  	sqlBean db =new sqlBean();
	  	try{
	  		ResultSet rs=db.executeQuery(sql);
	  		if(rs.next()){
	  			f=true;
	  		}
	  		else{
	  			f=false;
	  		}
	  	}catch(Exception e){ e.getMessage();}
	  	return f;
    }
	public boolean Login(String cid,String sid){   
	  	boolean f=true;
	   String sql="select sid from score where (cid ='"+cid+"' and sid='"+sid+"')";
	  	sqlBean db =new sqlBean();
	  	try{
	  		ResultSet rs=db.executeQuery(sql);
	  		if(rs.next()){ f=true;}
	  		else{ f=false;}
	  	}catch(Exception e){ e.getMessage();}
	  	return f;
    }
	public ResultSet  getSco(String sid){
		String sql="select cid,cname,credit,pscore,qscore,grade,jpa from score where sid='"+sid+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	public ResultSet  getScoOneCou(String c_id){
		String sql="select score.sid,student.sname,score.credit,student.sclass,student.smajor,score.grade,score.jpa from student,score where (student.id=score.sid and cid='"+c_id+"')";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	 	
	public ResultSet  getSc(String sid){
		String sql="select cid,cname,credit,pscore,qscore,grade,jpa from score where sid='"+sid+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	public ResultSet  getScoreone(String sid){
		String sql="select cid,cname,credit,pscore,qscore,grade,jpa from score where sid='"+sid+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	public void addScore(String cid,String cname,double credit,String sid,int pscore,int qscore,int grade,double jpa){		  
		String sql="insert into score(cid,cname,credit,sid,pscore,qscore,grade,jpa) VALUES ('"
			+cid+"','"+cname+"','"+credit+"','"+sid+"','"+pscore+"','"+qscore+"','"+grade+"','"+jpa+"')";
		sqlBean db =new sqlBean();		          
		db.executeInsert(sql);
    }
	public int deleteScore(String sid){
		int num=0;
		String sql="delete from score where sid='"+sid+"'";
		sqlBean db=new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
	public int deleteStuScore(String cno,String sid){
		int num=0;
		String sql="delete from score where (cid='"+cid+"' and sid='"+sid+"')";
		sqlBean db=new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
	public void updatescore(String sid,String cid,int pscore,int qscore,int grade,double jpa){
		String sql="update score set pscore='"+pscore+"',qscore='"+qscore+"',grade='"+grade+"',jpa='"+jpa+"'"+"where sid='"+sid+"' and cid='"+cid+"'";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public ResultSet getone(String sid){
		String sql="select * from score where sid='"+sid+"'";
		sqlBean db=new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}
	public void addave_point(String sid,double averagepoint){		  
		String sql="update rank set averagepoint='"+averagepoint+"' where sid='"+sid+"'";
		sqlBean db =new sqlBean();		          
		db.executeInsert(sql);
    }
	public void addsid(String sid){
		String sql="insert into rank (sid) VALUES ('"+sid+"')";
		sqlBean db =new sqlBean();		          
		db.executeInsert(sql);
	}

}
