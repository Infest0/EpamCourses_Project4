package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoFactory;
import model.PatientHistoryService;
import enteties.PatientHistory;
import enteties.User;

/**
 * Encapsulates editing history function in system
 * @author Nick
 *
 */
public class EditCurrentHistoryTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter(HIST_ID));
		PatientHistory patientHistory = new PatientHistoryService().find(id);
		request.setAttribute(MY_HISTORY_NOTES, patientHistory);
		request.setAttribute(HIST_ID, id);

		int userId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		String specialityType = DaoFactory.getFactory().createMedicDao().find(userId).getSpeciality();
		List<String> rules = DaoFactory.getFactory().createRulesDaoDB().getConstraints(specialityType);

		request.setAttribute(ADD_PROCEDURE_PROCEDURES, rules);

		return EDIT_HISTORY_PATH;
	}
}
