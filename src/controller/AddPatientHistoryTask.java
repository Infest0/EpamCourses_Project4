package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enteties.Patient;
import model.PatientService;

public class AddPatientHistoryTask implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Patient> patients = new PatientService().findFreePatients();
		request.setAttribute(FREE_PATIENTS, patients);
		return ADD_PATHIST_PATH;
	}
}
