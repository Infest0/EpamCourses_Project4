package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import daodb.DaoFactoryDB;
import enteties.User;

/**
 * Encapsulates dischanting the patient function in system
 * 
 * @author Nick
 *
 */
public class OutPatientByMedicTask implements ITask {
	final static Logger logger = Logger.getLogger(OutPatientByMedicTask.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));
		int medicId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		
		
		DaoFactoryDB.getFactory().createPatientHistoryDao().dischangeByMedic(medicId, historyId);
		logger.info(String.format(OUT_PATIENT, historyId, medicId));

		return new ViewUserHistoriesTask().execute(request, response);
	}
}
