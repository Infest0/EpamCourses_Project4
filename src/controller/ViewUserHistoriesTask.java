package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.PatientHistory;
import enteties.User;
import model.PatientHistoryService;

/**
 * Encapsulates finding user histories function in system
 * 
 * @author Nick
 *
 */
public class ViewUserHistoriesTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     	int medicId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		List<PatientHistory> patientHistories = new PatientHistoryService().findByMedicId(medicId);
		request.setAttribute(HISTORIES_LIST, patientHistories);
		request.setAttribute(OPEN_HISTORIES_ACTION, HISTORIES_OPEN_MEDIC);
		return HISTORIES_PATH;
	}
}
