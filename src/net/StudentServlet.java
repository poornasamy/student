package net;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String METHO_LOGIN = "/loginme";
       
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        try
        {
            super.init();
        }
        catch (ServletException e)
        {
            // TODO Auto-generated catch block
            System.out.println("StudentServlet init failed");
            e.printStackTrace();
        }
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Hello World</h1>");
	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pathInfo = request.getPathInfo(); 
	    String sessionuser = null;
	    HttpSession session = request.getSession();
	    if(pathInfo.equals(METHO_LOGIN))
	    {
	        String uname = request.getParameter("student_name");
	        String password = request.getParameter("student_password");
	        if(User.isValidUser(uname, password, request))
	        {
	            sessionuser = (String) session.getAttribute("user");
	        }
	        else
	        {
	            session.invalidate();
	        }
	        if(sessionuser != null)
	        {
	            response.sendRedirect("../home.jsp");
	        }
	        else
	        {
	            response.sendRedirect("../login.jsp");
	        }
	    }
	}

}
