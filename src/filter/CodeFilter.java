package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CodeFilter
 */
@WebFilter("/CodeFilter")
public class CodeFilter implements Filter {
    public void destroy() {
    	System.out.println("--过滤器销毁--");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    	//对request和response进行一些处理
    	req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //System.out.println("fifter执行前");
        chain.doFilter(req, resp);
        //System.out.println("fifter执行后");
    }

    public void init(FilterConfig config) throws ServletException {
    	System.out.println("--过滤器初始化--");
    }

}
