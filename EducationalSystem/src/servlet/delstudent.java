package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.student;
import bean.coursescore;
public class delstudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public delstudent() {
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
		response.setCharacterEncoding("utf-8");
		boolean f;
		String message;
	    String s_id=request.getParameter("s_id");
	    student stu=new student();
	    coursescore cou=new coursescore();
	    stu.deleteStudent(s_id);
    	cou.deleteScore(s_id);
	    out.print("删除学生成功，正在返回~~~");
		response.setHeader("refresh", "1.5;url=/stu_score_ms/manager/showstudent.jsp");
	}
	    /*f=stu.haslogin(s_id);
	    if(f==true){
	    	stu.deleteStudent(s_id);
	    	cou.deleteScore(s_id);
	    	message="删除成功！";
	    	doError(request,response,message);
	    }
	    else{
	    	message="您要删除的学生不存在！";
	    	doError(request,response,message);
	    }
	}
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
    throws ServletException, IOException{
        request.setAttribute("problem", str);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
        rd.forward(request, response);
    }*/

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
