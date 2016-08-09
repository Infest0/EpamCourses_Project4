package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import enteties.Patient;
import enteties.User;
import model.PatientService;

/**
 * Encapsulates adding patient history function for admin in system
 * 
 * @author Nick
 *
 */
public class AddPatientHistoryTask implements ITask {
	final static Logger logger = Logger.getLogger(AddPatientHistoryTask.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Patient> patients = new PatientService().findFreePatients();
		request.setAttribute(FREE_PATIENTS, patients);
		int adminId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();

		request.setAttribute(HIST_ID, request.getParameter(HIST_ID));
		
		logger.info(String.format(PATIENT_HISTORY_ADDED, Integer.valueOf(request.getParameter(HIST_ID)), adminId));

		return ADD_PATHIST_PATH;
	}
}
