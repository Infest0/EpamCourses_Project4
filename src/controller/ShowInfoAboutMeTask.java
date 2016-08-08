package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.Person;
import enteties.User;
import model.PersonService;

/**
 * Encapsulates showing info about current user in system
 * @author Nick
 *
 */
public class ShowInfoAboutMeTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = ((User)request.getSession().getAttribute(SESSION_USER)).getId();
		Person person = new PersonService().find(id);
		request.setAttribute(ME_INFO_PERSON, person);
		return ME_INFO_PATH;
	}
}
