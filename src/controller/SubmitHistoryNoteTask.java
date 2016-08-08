package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import dao.DaoFactory;
import enteties.PatientHistory;
import enteties.User;
import model.PatientHistoryNoteService;
import model.PatientHistoryService;

/**
 * Encapsulates submitting note function in system
 * @author Nick
 *
 */
public class SubmitHistoryNoteTask implements ITask {
	final static Logger logger = Logger.getLogger(SubmitHistoryNoteTask.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theme = request.getParameter(ADD_HISTORY_THEME);
		int historyId = Integer.valueOf(request.getParameter(HIST_ID));

		new PatientHistoryNoteService().addNewHistory(theme, request.getParameter(ADD_HISTORY_TEXT), historyId);
		request.setAttribute(ADD_RESULT_MSG, ADD_NOTE_RESULT);

		logger.info(HISTORY_NOTE_ADDED + theme + HISTORY_NOTE_ADDED_TO + historyId);
		
		int idUser = Integer.valueOf(request.getParameter(HIST_ID));
		PatientHistory patientHistory = new PatientHistoryService().find(idUser);
		request.setAttribute(MY_HISTORY_NOTES, patientHistory);
		request.setAttribute(HIST_ID, idUser);

		int userId = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		String specialityType = DaoFactory.getFactory().createMedicDao().find(userId).getSpeciality();
		List<String> rules = DaoFactory.getFactory().createRulesDaoDB().getConstraints(specialityType);

		request.setAttribute(ADD_PROCEDURE_PROCEDURES, rules);
		
		return EDIT_HISTORY_PATH;
	}
}
