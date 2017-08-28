package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.course;
import bean.coursescore;
import bean.studentcourse;

public class addscore extends HttpServlet {

	private HttpServletRequest request;

	/**
	 * Constructor of the object.
	 */
	public addscore() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String message;
	    boolean f=true;	                             	
	    String cid=request.getParameter("cid");;
	    String sid= request.getParameter("sid");
	    String ps=request.getParameter("pscore");
	    String qs=request.getParameter("qscore");	        
	        course cou=new course();	        
	        ResultSet rs=cou.getCinfo(cid);
	        try{
	        	if(rs.next()){
	        		String cname=rs.getString("cname");
	        		double credit=rs.getDouble("credit");
	        		coursescore sco=new coursescore();	        
	     	        f=sco.Login(cid, sid);  
	     	        if(f==true){
	     	        	message="该成绩已添加，请返回！！！";
	     	        	doError(request,response,message);
	     	        }
	     	        else{
	     	        	int pscore=Integer.valueOf(ps);
	     	            int qscore=Integer.valueOf(qs);		            
	     	            if(ps.equals(""))
	     	            	pscore=0;
	     	            if(qs.equals(""))
	     	            	qscore=0;
	     		        int grade=(int)(pscore*0.3+qscore*0.7);
	     	        	double kpoint=getJpa(request,response,grade);
	     	        	
	     	        	sco.addScore(cid,cname,credit,sid,pscore,qscore,grade,kpoint);
	     	            message="添加成功！！！";
	     	            doError(request,response,message);
	     	        }
	        	}
	        	else{
	        		message="学生没有选课程，请重新添加！！！";
	        		doError(request,response,message);
	        	}
	        }
	        catch(SQLException e){
	        	System.err.println("添加有误！"+e.getMessage());
	        }	        
	    }
	 /*   if("new1".equalsIgnoreCase(action)) {
	    	//ServletRequest session;
	    	HttpSession session1 =request.getSession(true);
	    	String cno_id=(String)session1.getAttribute("cno_id");
			String cla_id=(String)session1.getAttribute("cla_id");		
			String kai_id=(String)session1.getAttribute("kai_id");	
			int num=Integer.parseInt((String)session1.getAttribute("num"));				
			int i=1,j=200;
			coursescore sco=new coursescore();
		    studentcourse stucou=new studentcourse();
		    ResultSet rs=stucou.getStuCou(cno_id, cla_id, kai_id);
		    try{		    	
		        while(rs.next()&i<=num){	       
			        String cname=rs.getString("cname");
			        double credit=rs.getDouble("credit");
			        String s_id= rs.getString("sid");
			        String ps=request.getParameter(Integer.toString(i));			            
			        String qs=request.getParameter(Integer.toString(j));			            
			        double pscore=Double.valueOf(ps);			         
			        double qscore=Double.valueOf(qs);
			        if(ps.equals(""))
			            pscore=0;
			        if(qs.equals(""))
			            qscore=0;
			        int grade=(int) (pscore*0.3+qscore*0.7);
			        double kpoint1=getJpa(request,response,grade);
			        double kpoint=credit*kpoint1;
		     	        sco.setCid(cno_id);
		     	        sco.setCname(cname);
		     	        sco.setCredit(credit);
		     	        sco.setSid(s_id);
		     	        sco.setPscore(pscore);
		     	        sco.setQscore(qscore);
		     	        sco.setGrade(grade);
		     	        sco.setJpa(kpoint);
		     	        sco.addScore();
		     	        i++; j++;		     	            
		        }
		        doError(request,response,"添加成功！！！");
	     }
		 catch(SQLException e){
        	 System.err.println("添加有误！"+e.getMessage());
         }
	  }
	}*/
	public double getJpa(HttpServletRequest request,HttpServletResponse response,int grade)
            throws ServletException, IOException {	
     	double jpa;
     	if(grade>=90)
     		jpa=4.0;
     	else if(grade>=85)
     		jpa=3.7;
     	else if(grade>=82)
     		jpa=3.3;
     	else if(grade>=78)
     		jpa=3.0;
     	else if(grade>=75)
     		jpa=2.7;
     	else if(grade>=72)
     		jpa=2.3;
     	else if(grade>=68)
     		jpa=2.0;
     	else if(grade>=66)
     		jpa=1.7;
     	else if(grade>=64)
     		jpa=1.3;
     	else if(grade>=60)
     		jpa=1.0;
     	else 
     		jpa=0.0;	
     	return jpa;
	}
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
            throws ServletException, IOException {
        request.setAttribute("problem", str);
        request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
    }

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
