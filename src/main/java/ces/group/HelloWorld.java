package ces.group;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	message = "Hello World , Nect To Meet You: ";
    	System.out.println("message");
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		System.out.println("message"+"1");
		String action1=request.getParameter("key2");
		if("login_input".equals(action)){
			System.out.println("message"+"2");
			 request.getRequestDispatcher("login.jsp").forward(request , response); 
		}
		else if("login".equals(action)){
			 String name = request.getParameter("name");  
			 message=name;
	            String password = request.getParameter("password");
	          PrintWriter writer = response.getWriter();
	    	writer.write("<h1>" + action1 + "</h1>"+"<h1>" + password + "</h1>"); 
		} 
		
		//PrintWriter writer = response.getWriter();
		//writer.write("<h1>" + message + "</h1>");
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
