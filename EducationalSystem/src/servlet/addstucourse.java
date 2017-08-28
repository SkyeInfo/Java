package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.studentcourse;

public class addstucourse extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addstucourse() {
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
		boolean f=true;
		String message;
		String sid=request.getParameter("sid");
		String cno=request.getParameter("cno");
		String cname=request.getParameter("cname");
		String clnum=request.getParameter("clnum");
		int capacity=Integer.parseInt(request.getParameter("capacity"));
		double credit=Double.parseDouble(request.getParameter("credit"));
		
		studentcourse stucou=new studentcourse();
		f=stucou.isValid(sid,cno);
		if(f==true){
			message="对不起，该学生已经选择了该课程!";
		  	doError(request,response,message);
		}
		else if(sid.equals("")){
			message="对不起，学号不能为空！！！";
		  	doError(request,response,message);
		}
		else if(cno.equals("")){
			message="对不起，课程号不能为空！！！";
		  	doError(request,response,message);
		}
		else if(cname.equals("")){
			message="对不起，课程名不能为空！！！";
		  	doError(request,response,message);
		}			
		else{
			stucou.setSid(sid);
			stucou.setCid(cno);
			stucou.setCname(cname);
			stucou.setClnum(clnum);
			stucou.setCapacity(capacity);
			stucou.setCredit(credit);
			stucou.addstucourse();
			message="添加成功！！！";
		  	doError(request,response,message);
		}		
	}
	
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
    throws ServletException, IOException {
		request.setAttribute("problem", str);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
        rd.forward(request, response);
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
