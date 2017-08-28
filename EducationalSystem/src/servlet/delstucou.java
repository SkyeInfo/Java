package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.coursescore;
import bean.studentcourse;

public class delstucou extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public delstucou() {
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
		doPost(request,response);
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
		boolean f;
		String message;
	    	String sid = request.getParameter("s_id");
	    	String cid = request.getParameter("c_id");
	    	studentcourse stucou=new studentcourse();
	    	coursescore cou=new coursescore();
	    	f=stucou.isValid(sid, cid);
	    		stucou.deleteStucou(sid,cid);
	    		cou.deleteStuScore(sid, cid);
	    		out.print("<center>学生课程删除成功，正在返回~~~</center>");
	    		response.setHeader("refresh", "1.5;url=/stu_score_ms/manager/showstudent.jsp");
	      	
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
