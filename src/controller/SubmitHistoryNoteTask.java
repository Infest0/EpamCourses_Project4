package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import model.PatientHistoryNoteService;

/**
 * Encapsulates submitting note function in system
 * 
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

		logger.info(String.format(HISTORY_NOTE_ADDED, theme, historyId));

		return new EditCurrentHistoryTask().execute(request, response);
	}
}
