package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.PatientHistory;
import enteties.User;
import model.PatientHistoryService;

/**
 * Encapsulates showing current history  function in system

 * @author Nick
 *
 */
public class ShowCurrentHistoryTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		PatientHistory patientHistory = new PatientHistoryService().findByPatientId(id);
		request.setAttribute(MY_HISTORY_NOTES, patientHistory);
		return MY_HISTORY_PATH;
	}
}
