package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sqlBean;

public class updateTpassword extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateTpassword() {
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
			String t_id=request.getParameter("id");
			String old;
			String pw1=null;
			String pw2=null;
			old=request.getParameter("oldpassword");
			pw1=request.getParameter("password1");
			pw2=request.getParameter("password2");
			if(!old.equals(t_id)&!old.equals(""))
				doError(request,response,"原始密码错误");
			else if(pw1.equals("")&pw2.equals(""))
				doError(request,response,"密码不能为空！");
			else if(!pw1.equals(pw2)&!old.equals(""))
				doError(request,response,"密码不一致，请重新输入！");
			else{
				String sql="update teacher set password='"+pw1+"'where id='"+t_id+"'";
				sqlBean db=new sqlBean();
				db.executeInsert(sql);				
				doError(request,response,"您的密码修改成功！！！");
			}	
		}
		public void doError(HttpServletRequest request,HttpServletResponse response,String str)
		throws ServletException,IOException{
			request.setAttribute("problem", str);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
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
