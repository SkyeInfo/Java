package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.teacher;
public class addteacher extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addteacher() {
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
	        teacher tea= new teacher();                     	
	        String tid=request.getParameter("tid");
	        String tname=request.getParameter("tname");
	        String tpassword= request.getParameter("tpassword");
	        
		  	f=tea.isValid(tid);
		  	if(f==true){
		  	    message="对不起，该工号已经被注册过了!";
		  		doError(request,response,message);
		    }
		  	else if(tid.equals("")){
		  	    message="工号不能为空，请重新填写！";
		  		doError(request,response,message);
		  	}
		  	else if(tname.equals("")){
		  		message="教师姓名不能为空，请重新填写！";
		  		doError(request,response,message);
		  	}
		  	else if(tpassword.equals("")){
		  		message="密码不能为空，请重新填写！";
		  		doError(request,response,message);
		  	}
		  	else{
	            tea.setId(tid);
	            tea.setName(tname);
	            tea.setPassword(tpassword);
	            tea.addTeacher();
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
