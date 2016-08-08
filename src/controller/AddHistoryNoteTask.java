package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Encapsulates adding note function in system
 * @author Nick
 *
 */
public class AddHistoryNoteTask implements ITask {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(HIST_ID, request.getParameter(HIST_ID));
		return HISTORY_NOTE_PATH;
	}
}
