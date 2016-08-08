package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.PatientHistory;
import model.PatientHistoryService;

public class ShowNotDischangedPatientHistories implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PatientHistory> patientHistories = new PatientHistoryService().findNotDischanged();
		request.setAttribute(HISTORIES_LIST, patientHistories);
		request.setAttribute(OPEN_HISTORIES_ACTION, HISTORIES_OPEN_ADMIN);
		return HISTORIES_PATH;
	}

}
