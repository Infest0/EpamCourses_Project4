package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PatientHistoryService;

/**
 * Encapsulates adding medic to history admin function in system
 * 
 * @author Nick
 *
 */
public class AddMedicToHistoryTask implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));
		int medicId = Integer.valueOf(request.getParameter(SELECTED_MEDIC));
		new PatientHistoryService().addMedicToHistory(medicId, historyId);
		return new ManageCurrentHistory().execute(request, response);
	}

}
