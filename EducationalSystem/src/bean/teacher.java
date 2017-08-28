package bean;

import java.sql.*;

public class teacher {
	private String id;
	private String name;
	private String password;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public ResultSet  getTeacher(){
		String sql="select * from teacher";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public ResultSet  getTeaOne(String t_id){
		String sql="select * from teacher where id ='"+t_id+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public boolean isValid(String id){   
		boolean f=true;
		String sql="select id from teacher where id ='"+id+"'";
		sqlBean db =new sqlBean();
		try{
		    ResultSet rs=db.executeQuery(sql);
		  	if(rs.next()){f=true;}
		  	else{f=false;}
	    }catch(Exception e){ e.getMessage();}
		return f;
	}
	public void addTeacher(){		  
		String sql="insert into teacher(id,tname,password) VALUES ('"+id+"','"+name+"','"+password+"')";
		sqlBean db =new sqlBean();		          
		db.executeInsert(sql);
    }
	public int deleteTeacher(String id){
	    int num=0;
	    String sql="delete  from teacher where id ='"+id+"' ";
	    sqlBean db= new sqlBean();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void updateTeacher(){	
	    String sql="update teacher "+" set tname='"+name+"',"+" password='"+password+"' "+" where id='"+id+"'";
	    sqlBean db= new sqlBean();
	    db.executeInsert(sql);
    }


}
