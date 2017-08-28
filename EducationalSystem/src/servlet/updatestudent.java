package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.student;

public class updatestudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updatestudent() {
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
		String sid,sname,smajor,sclass,spassword;
		sid=request.getParameter("sid");
		//id=request.getParameter("id");
		sname=request.getParameter("sname");
		smajor=request.getParameter("smojor");
		sclass=request.getParameter("sclass");
		spassword=request.getParameter("password");
		//if(hasExist(request,response,xuehao)==false){
			student stu=new student();
			stu.setSid(sid);
			stu.setSname(sname);
			//stu.setSex(sex);
			stu.setSmajor(smajor);
			stu.setSclass(sclass);
			stu.setSpassword(spassword);
			stu.updateStudent();
			out.print("学生修改成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_score_ms/manager/showstudent.jsp");
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
		String sid,sname,smajor,sclass,spassword;
		sid=request.getParameter("sid");
		//id=request.getParameter("id");
		sname=request.getParameter("sname");
		smajor=request.getParameter("smojor");
		sclass=request.getParameter("sclass");
		spassword=request.getParameter("password");
		//if(hasExist(request,response,xuehao)==false){
			student stu=new student();
			stu.setSid(sid);
			stu.setSname(sname);
			//stu.setSex(sex);
			stu.setSmajor(smajor);
			stu.setSclass(sclass);
			stu.setSpassword(spassword);
			stu.updateStudent();
			out.print("学生修改成功！正在返回，请稍候……");
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
