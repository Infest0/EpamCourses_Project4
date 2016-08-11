package filter;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filter, that checks login status of user
 * @author Nick
 *
 */
public class AuthChecker implements Filter {
	
	/**
	 * If session object or session attributes are null redirects 
	 * on login page
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String redirect = req.getContextPath() + LOGIN_PATH;
		String uri = req.getRequestURI();
		String prev = ((HttpServletRequest) request).getHeader("referer"); // header name, need no constant value 

		if ((session != null && session.getAttribute(SESSION_ROLE) != null) || uri.equals(redirect)
				|| (prev != null && prev.contains(LOGIN_PATH))) {
			filterChain.doFilter(request, response);
		} else {
			resp.sendRedirect(redirect);
		}
	}

	public void init(FilterConfig arg0) throws ServletException { }

	public void destroy() { }
}
