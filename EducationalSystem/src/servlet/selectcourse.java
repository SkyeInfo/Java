package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.studentcourse;
import bean.course;
import bean.coursescore;

public class selectcourse extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public selectcourse() {
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sid,cid,clsid;
		HttpSession session=request.getSession();
		sid=(String)session.getAttribute("id");
		cid=request.getParameter("cid");
		course cou=new course();
		studentcourse selcou=new studentcourse();
		coursescore sc=new coursescore();
		sc.addsid(sid);
		if(selcou.isValid(sid,cid)==false){
			ResultSet rs=cou.getCinfo(cid);
			try {
				while(rs.next()){
					selcou.setSid(sid);
					selcou.setCid(cid);
					selcou.setClnum(rs.getString("clnum"));
					selcou.setCname(rs.getString("cname"));
					selcou.setCredit(rs.getDouble("credit"));
					selcou.setCapacity(rs.getInt("capacity"));
					selcou.addstucourse();
					out.print("选课成功！正在返回，请稍候……");
					response.setHeader("refresh", "2;url=/stu_score_ms/student/showstucou.jsp");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		else{
			out.print("对不起，您已经选过该课程了！");
			response.setHeader("refresh", "2;url=/stu_score_ms/student/selectcourse.jsp");
		}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
