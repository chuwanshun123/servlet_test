package ces.group;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Testmysql
 */
@WebServlet("/Testmysql")
public class Testmysql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Testmysql() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;

		java.sql.Statement stmt = null;
		java.sql.PreparedStatement ps = null;
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "Servlet Mysql 测试 - 菜鸟教程";
		String action = request.getParameter("action");

		try {
			// 注册 JDBC 驱动器
			Class.forName("com.mysql.jdbc.Driver");

			// 打开一个连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if ("login_input".equals(action)) {
				stmt = conn.createStatement();
				String sql1;
				sql1 = "SELECT username,password FROM data";
				ResultSet rs = stmt.executeQuery(sql1);
				
				String User_name= request.getParameter("name");
				
			
				while (rs.next()) {
					System.out.println(rs.getString("username").equals(User_name)+"111");
					System.out.println(rs.getString("password").equals(request.getParameter("password"))+"22");	
					if(rs.getString("username").equals(User_name)&&rs.getString("password").equals(request.getParameter("password"))){
						request.getRequestDispatcher("login.jsp").forward(request, response);
						break;
					}
				}
				
			} else if ("login_mysql".equals(action)) {
				// request.getRequestDispatcher("login.jsp").forward(request,
				// response);
				System.out.println("进入更新。。。");

				// 编写预处理 SQL 语句
				String sql = "INSERT INTO websites VALUES(?,?,?,?,?)";

				// 实例化 PreparedStatement
				ps = conn.prepareStatement(sql);

				// 传入参数，这里的参数来自于一个带有表单的jsp文件，很容易实现
				ps.setString(1, request.getParameter("id"));
				ps.setString(2, request.getParameter("name"));
				ps.setString(3, request.getParameter("url"));
				ps.setString(4, request.getParameter("alexa"));
				ps.setString(5, request.getParameter("country"));

				ps.executeUpdate();
				System.out.println("数据库更新成功？");
			} else if ("login_mysql_delete".equals(action)) {
				int idd = Integer.parseInt(request.getParameter("id1"));
				String sql_detele = "DELETE FROM websites WHERE id>" + idd;
				ps = conn.prepareStatement(sql_detele);
				ps.executeUpdate();
				// 执行 SQL 查询
				stmt = conn.createStatement();
				String sql1;
				sql1 = "SELECT id, name, url FROM websites";
				ResultSet rs = (stmt).executeQuery(sql1);
				out.println("数据库内容列表");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				
				// 展开结果集数据库
				while (rs.next()) {
					// 通过字段检索
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String url = rs.getString("url");

					// 输出数据

					out.println("ID: " + id);
					out.println(", 站点名称: " + name);
					out.println(", 站点 URL: " + url);
					out.println("<br />");
				}
				out.println("</body></html>");
				
				// 完成后关闭
				rs.close();
				(stmt).close();
				conn.close();
				
			} else if ("login_sign_complete".equals(action)) {
				String sql2 = "INSERT INTO data VALUES(?,?,?)";
				ps = conn.prepareStatement(sql2);

				// 传入参数，这里的参数来自于一个带有表单的jsp文件，很容易实现
				String User_name = request.getParameter("name");
				String User_email = request.getParameter("email");
				String User_password = request.getParameter("password");
				if (User_name.length() != 0 && User_email.length() != 0 && User_password.length() != 0) {
					ps.setString(1, User_name);
					ps.setString(2, User_password);
					ps.setString(3, User_email);
					
					ps.executeUpdate();
					request.getRequestDispatcher("index.jsp").forward(request, response);
					

			}
		
			}
			
					
					} catch (SQLException se) {
						// 处理 JDBC 错误
						se.printStackTrace();
					} catch (Exception e) {
						// 处理 Class.forName 错误
						e.printStackTrace();
					} finally {
						// 最后是用于关闭资源的块
						try {
							if (stmt != null)
								(stmt).close();
						} catch (SQLException se2) {
						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}

					}

		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
