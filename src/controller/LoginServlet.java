package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.User;
import model.LoginService;
import model.RoleService;

/**
 * Login class, needed for checking password and username match
 * @author Nick
 *
 */
@WebServlet(LOGIN_ANNOTATION)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new LoginService().checkParameters(request.getParameter(LOGIN_USNAME), 
					request.getParameter(LOGIN_PASS));
		RoleService roleService = new RoleService();

		if (user != null) {
			request.getSession().setAttribute(SESSION_ROLE, roleService.defineRoles(user.getId()));
			request.getSession().setAttribute(SESSION_USER, user);
			response.sendRedirect(request.getContextPath() + INDEX_PATH);
		} else {
			request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
		}
	}
}
