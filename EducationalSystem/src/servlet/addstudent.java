package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.student;

public class addstudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addstudent() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		String message;
		String s_id=request.getParameter("sid");
		String s_name=request.getParameter("sname");
		String password=request.getParameter("password");
		String s_class=request.getParameter("sclass");
		String s_major=request.getParameter("smajor");
		
		student stu=new student();
		boolean f=stu.haslogin(s_id);
		if(f==true){
			message="¶Ô²»Æð£¬¸ÃÑ§ºÅÒÑ±»×¢²á£¡";
			doError(request,response,message);
		}
		else if(s_id.equals("")){
			message="Ñ§ºÅ²»ÄÜÎª¿Õ£¬ÇëÖØÐÂÌîÐ´!";
			doError(request,response,message);
		}
		else if(s_name.equals("")){
			message="ÐÕÃû²»ÄÜÎª¿Õ£¬ÇëÖØÐÂÌîÐ´£¡";
			doError(request,response,message);
		}
		else if(password.equals("")){
			message="ÃÜÂë²»ÄÜÎª¿Õ£¬ÇëÖØÐÂÌîÐ´£¡";
			doError(request,response,message);
		}
		else{
			stu.setSid(s_id);
			stu.setSname(s_name);
			stu.setSpassword(password);
			stu.setSclass(s_class);
			stu.setSmajor(s_major);
			stu.addStudent();
			out.print("Ñ§ÉúÌí¼Ó³É¹¦£¡ÕýÔÚ·µ»Ø£¬ÇëÉÔºò¡­¡­");
			response.setHeader("refresh", "1.5;url=/stu_score_ms/manager/showstudent.jsp");
		}
	}
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
	throws ServletException,IOException{
		request.setAttribute("problem", str);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
        rd.forward(request, response);
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

		doGet(request,response);
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
