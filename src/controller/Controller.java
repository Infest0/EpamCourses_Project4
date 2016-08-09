package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(CONTROLLER_ANNOTATION)

/**
 * Main Controller in system, takes requests from ajax and returns repsonse in
 * out writer
 * 
 * @author Nick
 *
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND_PARAM);
		ITask command = TaskList.valueOf(commandName).getTask();
		String goTo = command.execute(request, response);
		CharArrayWriterResponse customResponse = new CharArrayWriterResponse(response);
		request.getRequestDispatcher(goTo).include(request, customResponse);
		response.getWriter().append(customResponse.getOutput());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
