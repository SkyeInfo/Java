package servlet;

/**
 * @author SkyeInfo
 * @LastModifyTime 2017/8/28
 * @LastModify SkyeInfo
 */

import java.io.IOException;
import java.io.PrintWriter;
import bean.course;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addCourse extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public addCourse() {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.print("This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("</BODY>");
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String cid,cname,clnum;
        double credit;
        int capacity;
        boolean f;
        cid=request.getParameter("cid");
        clnum=request.getParameter("clnum");
        cname=request.getParameter("cname");
        credit=Double.parseDouble((request.getParameter("credit")));
        capacity=Integer.parseInt(request.getParameter("capacity"));
        course cou=new course();
        f=cou.isValid(cid);
        if(f==false){
            cou.setCid(cid);
            cou.setClnum(clnum);
            cou.setCredit(credit);
            cou.setCname(cname);
            cou.setCapacity(capacity);
            cou.addCourse();
            out.print("课程添加成功！正在返回，请稍候……");
            response.setHeader("refresh", "1.5;url=/stu_score_ms/manager/showcourse.jsp");
        }
        else{
            String message="对不起，您要添加的课程号已存在！";
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
