package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import daodb.DaoFactoryDB;
import enteties.PatientHistory;
import enteties.User;
import model.PatientHistoryService;

/**
 * Encapsulates dischanting the patient function in system
 * 
 * @author Nick
 *
 */
public class OutPatientTask implements ITask {
	final static Logger logger = Logger.getLogger(OutPatientTask.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));
		int medicId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();

		DaoFactoryDB.getFactory().createPatientHistoryDao().dischangeByMedic(medicId, historyId);

		logger.info(String.format(OUT_PATIENT, historyId, medicId));
	
		List<PatientHistory> patientHistories = new PatientHistoryService().findByMedicId(medicId);
		request.getSession().setAttribute(HISTORIES_LIST, patientHistories);
		return HISTORIES_PATH;
	}
}
