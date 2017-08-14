package ces.group;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		/*
		 * HttpSession session = request.getSession(); // 为名字和姓氏创建 Cookie Cookie
		 * name = new Cookie("name",
		 * URLEncoder.encode(request.getParameter("name"), "UTF-8")); // 中文转码
		 * Cookie url = new Cookie("url", request.getParameter("url"));
		 * 
		 * // 为两个 Cookie 设置过期日期为 24 小时后 name.setMaxAge(60 * 60 * 24);
		 * url.setMaxAge(60 * 60 * 24);
		 * 
		 * // 在响应头中添加两个 Cookie response.addCookie(name);
		 * response.addCookie(url); String action =
		 * request.getParameter("action"); if ("login_cookies".equals(action)) {
		 * request.getRequestDispatcher("login.jsp").forward(request, response);
		 * session.setAttribute("para1", name); }
		 */
		// 测试提交表单的

		String action = request.getParameter("action");
		System.out.println("message" + "1");
		
	 if ("login".equals(action)) {
			String name = request.getParameter("name");
			message = name;
			String password = request.getParameter("password");
			PrintWriter writer = response.getWriter();
			writer.write("<h1>" + action + "</h1>" + "<h1>" + password + "</h1>");
		}
		else if("login_sign".equals(action)){
			request.getRequestDispatcher("sign.jsp").forward(request, response);
		}
		
	

		// PrintWriter writer = response.getWriter();
		// writer.write("<h1>" + message + "</h1>");
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
