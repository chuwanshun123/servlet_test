package ces.group;

import javax.servlet.*;
import java.util.*;

//实现 Filter 类
public class TestFilter implements Filter  {
	public void  init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site"); 

		// 输出初始化参数
		System.out.println("过滤器初始化: " + site); 
	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

		// 输出站点名称
		System.out.println("开始过滤：http://www.runoob.com");

		// 把请求传回过滤链
		chain.doFilter(request,response);
	}
	public void destroy( ){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
		System.out.println("摧毁了"); 
	}
}
