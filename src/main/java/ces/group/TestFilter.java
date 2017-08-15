package ces.group;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

//实现 Filter 类
public class TestFilter implements Filter  {
	public void  init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site"); 

		// 输出初始化参数
		System.out.println("过滤器初始化: " + site); 
	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain ) throws java.io.IOException, ServletException {

		HttpServletRequest request1=(HttpServletRequest)request;
		HttpServletResponse response1=(HttpServletResponse)response;
		String currentURL= request1.getRequestURI();
		System.out.println(currentURL+"  getRequestURI");
		//返回当前系统路径   
		//对于第一部署方法，request.getContextPath()的返回值为空（即："",中间无空格，注意区分null)。
		//对于第二部署方法，其返回值为：/创建的文件夹的名称。（部署下webapps下）	
		String ctxPath = request1.getContextPath();
		System.out.println(ctxPath+"  getContextPath");
		String targetURL=currentURL.substring(ctxPath.length());
		System.out.println(targetURL+"  targetURL");
		HttpSession session =request1.getSession(false);
		String action = request1.getParameter("action");
		if(session!=null){
			System.out.println(session.getId()+"  sessionid");
		}
		
		if("/index.jsp".equals(targetURL)){
			chain.doFilter(request1,response1);
			return;
		}
		else{
			if("login_input".equals(action)==false){
			 response1.sendRedirect("/H2/index.jsp");
				System.out.println("被重定向了");
				return;
			}
			else{
				
				chain.doFilter(request1,response1);
				return;
			}
			
		}
		
		// 把请求传回过滤链
		
	}
	public void destroy( ){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
		System.out.println("摧毁了"); 
	}
}
