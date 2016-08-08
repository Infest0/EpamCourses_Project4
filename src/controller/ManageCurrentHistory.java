package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.Medic;
import model.MedicService;

public class ManageCurrentHistory implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));
		MedicService medicService = new MedicService();
		List<Medic> medics = medicService.findAllByPatientHistoryId(historyId);
		request.setAttribute(HISTORY_MEDICS, medics);
		List<Medic> availableMedics = medicService.findAllNotInPatientHistoryById(historyId);
		request.setAttribute(HISTORY_AVAILABLE_MEDICS, availableMedics);
		request.setAttribute(HIST_ID, historyId);
		return MANAGE_CURRENT_HISTORY_PATH;
	}

}
