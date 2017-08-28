package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sqlBean;

public class check extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public check() {
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
		String id=null;
		String password=null;
		String kind=null;
		id=request.getParameter("id");
		HttpSession session=request.getSession(true);
		session.setAttribute("id", String.valueOf(id));
		password=request.getParameter("password");
		kind=request.getParameter("kind");
		
		sqlBean db=new sqlBean();
		String pw="";
		String sql="select password from "+kind+" where id='"+id+"'";
		ResultSet rs=db.executeQuery(sql);
		try{
			if(rs.next()){
				pw=rs.getString("password");
				if(password.equals(pw))
					goo(request,response,kind);
				else{
					System.err.println("用户名或密码错误！");
					doError(request,response,"用户名或密码错误！");
				}
			}
		}
		catch(SQLException e){
			System.err.println("用户名或密码错误！"+e.getMessage());
			System.out.print("用户名或密码错误！"+e.getMessage());
		}
		catch(ServletException f){
			System.err.println("用户名或密码错误！"+f.getMessage());
		}
		catch(IOException g){
			System.err.println("用户名或密码错误！"+g.getMessage());
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
	public void goo(HttpServletRequest request,HttpServletResponse response,String kind)
	throws ServletException,IOException{
		if(kind.equals("student")){
			//控制页面跳转
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/student/student.jsp");
			rd.forward(request, response);
		}
		if(kind.equals("teacher")){
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/teacher/teacher.jsp");
			rd.forward(request, response);
		}
		if(kind.equals("manager")){
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/manager/manager.jsp");
			rd.forward(request, response);
		}
	}
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
			throws ServletException,IOException{
				request.setAttribute("problem", str);
				getServletConfig().getServletContext().getRequestDispatcher("/errorpage.jsp");
	}
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
