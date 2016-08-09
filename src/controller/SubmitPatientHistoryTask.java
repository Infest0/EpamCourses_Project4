package controller;

import static controller.ControllerParamHandler.*;
import static controller.LogMessages.*;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import dao.DaoFactory;
import enteties.PatientHistory;
import enteties.User;

/**
 * Encapsulates submitting patient history task in system function in system

 * @author Nick
 *
 */
public class SubmitPatientHistoryTask implements ITask {
	final static Logger logger = Logger.getLogger(SubmitOperation.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String complaints = request.getParameter(COMPLAINTS);
		int patientId = Integer.valueOf(request.getParameter(SELECTED_PATIENT));
		int userId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		PatientHistory patientHistory = new PatientHistory();

		patientHistory.setDateAdded(date);
		patientHistory.setPatientId(patientId);
		patientHistory.setComplaints(complaints);
		DaoFactory.getFactory().createPatientHistoryDao().create(patientHistory);
		
		logger.info(String.format(PATIENT_HISTORY_ADDED, patientId, userId));
		
		return new ShowNotDischangedPatientHistories().execute(request, response);
	}

}
