package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sqlBean;

public class updateMpassword extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateMpassword() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String m_id=request.getParameter("id");
		String old;
		String pw1=null;
		String pw2=null;
			old=request.getParameter("oldpassword");
			pw1=request.getParameter("password1");
			pw2=request.getParameter("password2");
			if(!old.equals(m_id)&!old.equals(""))
				doError(request,response,"ԭʼ�������");
			else if(pw1.equals("")&pw2.equals(""))
				doError(request,response,"���벻��Ϊ�գ�");
			else if(!pw1.equals(pw2)&!old.equals(""))
				doError(request,response,"���벻һ�£����������룡");
			else{
				String sql="update manager set password='"+pw1+"'where id='"+m_id+"'";
				sqlBean db=new sqlBean();
				db.executeInsert(sql);
				doError(request,response,"�޸ĳɹ�!!!");
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