package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.coursescore;

public class updatescore extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updatescore() {
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
		int pscore=Integer.parseInt(request.getParameter("pscore"));
		int qscore=Integer.valueOf(request.getParameter("qscore"));
		String sid=request.getParameter("sid");
		String cid=request.getParameter("cid");
		int grade=(int)(pscore*0.5+qscore*0.5);
     	double jpa=getJpa(request,response,grade);
		coursescore cs=new coursescore();
		cs.updatescore(sid, cid, pscore, qscore, grade, jpa);
		coursescore sc=new coursescore();
		ResultSet rs=sc.getone(sid);
		try {
			double sum_credit=0.0;//总学分
			double sum_point=0.0;//总学分积点
			while(rs.next()){				
				//String s_id=rs.getString("sid");
				double credit1=rs.getDouble("credit");
				double jpa1=rs.getDouble("jpa");
				sum_point=sum_point+credit1*jpa1;
				sum_credit=sum_credit+credit1;
			}
			double averagepoint=sum_point/sum_credit;
			sc.addave_point(sid,averagepoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("成绩修改成功！正在返回，请稍候。。。。。。");
		response.setHeader("refresh", "1.5;url=/stu_score_ms/teacher/searchonescore.jsp?s_id="+sid);
	}
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
