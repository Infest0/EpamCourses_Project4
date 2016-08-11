package controller;

import static controller.ControllerParamHandler.*;
import static controller.LogMessages.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import enteties.User;
import model.MedicService;
import model.PatientHistoryService;

/**
 * Encapsulates discharging the patient by admin function in system
 * 
 * @author Nick
 *
 */
public class OutPatientByAdminTask implements ITask {
	final static Logger logger = Logger.getLogger(OutPatientByAdminTask.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));		
		int adminId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		
		new PatientHistoryService().dischangeByAdmin(historyId);
		new MedicService().outHistoriesById(historyId);
		
		logger.info(String.format(DISHCANGE_PATIENT_BY_ADMIN, historyId, adminId));

		return new ShowNotDischangedPatientHistories().execute(request, response);
	}

}
