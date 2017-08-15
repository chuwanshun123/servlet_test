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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Testmysql
 */
@WebServlet("/Testmysql1")
public class Testmysql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC 椹卞姩鍚嶅強鏁版嵁搴� URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	// 鏁版嵁搴撶殑鐢ㄦ埛鍚嶄笌瀵嗙爜锛岄渶瑕佹牴鎹嚜宸辩殑璁剧疆
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
		// 璁剧疆鍝嶅簲鍐呭绫诲瀷
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "Servlet Mysql 娴嬭瘯 - 鑿滈笩鏁欑▼";
		String action = request.getParameter("action");

		try {
			// 娉ㄥ唽 JDBC 椹卞姩鍣�
			Class.forName("com.mysql.jdbc.Driver");

			// 鎵撳紑涓�涓繛鎺�
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if ("login_input".equals(action)) {
				stmt = conn.createStatement();
				String sql1;
				sql1 = "SELECT username,password FROM data";
				ResultSet rs = stmt.executeQuery(sql1);
				
				String User_name= request.getParameter("name");
				
			
				while (rs.next()) {
					
					if(rs.getString("username").equals(User_name)&&rs.getString("password").equals(request.getParameter("password"))){
						HttpSession session=request.getSession();
						session.setAttribute("user",User_name); 
						request.getRequestDispatcher("login.jsp").forward(request, response);
						return;
					}
				}
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else if ("login_mysql".equals(action)) {
				// request.getRequestDispatcher("login.jsp").forward(request,
				// response);
				System.out.println("杩涘叆鏇存柊銆傘�傘��");

				// 缂栧啓棰勫鐞� SQL 璇彞
				String sql = "INSERT INTO websites VALUES(?,?,?,?,?)";

				// 瀹炰緥鍖� PreparedStatement
				ps = conn.prepareStatement(sql);

				// 浼犲叆鍙傛暟锛岃繖閲岀殑鍙傛暟鏉ヨ嚜浜庝竴涓甫鏈夎〃鍗曠殑jsp鏂囦欢锛屽緢瀹规槗瀹炵幇
				ps.setString(1, request.getParameter("id"));
				ps.setString(2, request.getParameter("name"));
				ps.setString(3, request.getParameter("url"));
				ps.setString(4, request.getParameter("alexa"));
				ps.setString(5, request.getParameter("country"));

				ps.executeUpdate();
				System.out.println("鏁版嵁搴撴洿鏂版垚鍔燂紵");
			} else if ("login_mysql_delete".equals(action)) {
				int idd = Integer.parseInt(request.getParameter("id1"));
				String sql_detele = "DELETE FROM websites WHERE id>" + idd;
				ps = conn.prepareStatement(sql_detele);
				ps.executeUpdate();
				// 鎵ц SQL 鏌ヨ
				stmt = conn.createStatement();
				String sql1;
				sql1 = "SELECT id, name, url FROM websites";
				ResultSet rs = (stmt).executeQuery(sql1);
				out.println("鏁版嵁搴撳唴瀹瑰垪琛�");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				
				// 灞曞紑缁撴灉闆嗘暟鎹簱
				while (rs.next()) {
					// 閫氳繃瀛楁妫�绱�
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String url = rs.getString("url");

					// 杈撳嚭鏁版嵁

					out.println("ID: " + id);
					out.println(", 绔欑偣鍚嶇О: " + name);
					out.println(", 绔欑偣 URL: " + url);
					out.println("<br />");
				}
				out.println("</body></html>");
				
				// 瀹屾垚鍚庡叧闂�
				rs.close();
				(stmt).close();
				conn.close();
				
			} else if ("login_sign_complete".equals(action)) {
				String sql2 = "INSERT INTO data VALUES(?,?,?)";
				ps = conn.prepareStatement(sql2);

				// 浼犲叆鍙傛暟锛岃繖閲岀殑鍙傛暟鏉ヨ嚜浜庝竴涓甫鏈夎〃鍗曠殑jsp鏂囦欢锛屽緢瀹规槗瀹炵幇
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
						// 澶勭悊 JDBC 閿欒
						se.printStackTrace();
					} catch (Exception e) {
						// 澶勭悊 Class.forName 閿欒
						e.printStackTrace();
					} finally {
						// 鏈�鍚庢槸鐢ㄤ簬鍏抽棴璧勬簮鐨勫潡
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
