package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoFactory;
import enteties.User;

/**
 * Encapsulates adding procedure function in system
 * @author Nick
 *
 */
public class AddProcedureTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();

		String specialityType = DaoFactory.getFactory().createMedicDao().find(userId).getSpeciality();

		List<String> rules = DaoFactory.getFactory().createRulesDaoDB().getConstraints(specialityType);

		int histId = Integer.valueOf(request.getParameter(HIST_ID));

		request.setAttribute(ADD_PROCEDURE_PROCEDURES, rules);
		request.setAttribute(HIST_ID, histId);

		return ADD_PROCEDURE_PATH;
	}
}
