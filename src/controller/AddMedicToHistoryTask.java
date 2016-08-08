package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enteties.Medic;
import model.MedicService;
import model.PatientHistoryService;

public class AddMedicToHistoryTask implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));
		int medicId = Integer.valueOf(request.getParameter(SELECTED_MEDIC));

		new PatientHistoryService().addMedicToHistory(medicId, historyId);

		MedicService medicService = new MedicService();
		List<Medic> medics = medicService.findAllByPatientHistoryId(historyId);
		request.setAttribute(HISTORY_MEDICS, medics);
		List<Medic> availableMedics = medicService.findAllNotInPatientHistoryById(historyId);
		request.setAttribute(HISTORY_AVAILABLE_MEDICS, availableMedics);

		return MANAGE_CURRENT_HISTORY_PATH;
	}

}
