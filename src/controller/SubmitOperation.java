package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import enteties.Procedure;
import enteties.User;
import model.ProceduresService;

/**
 * Encapsulates submitting operation function in system
 * @author Nick
 *
 */
public class SubmitOperation implements ITask {
	final static Logger logger = Logger.getLogger(SubmitOperation.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProceduresService service = new ProceduresService();
		Procedure procedure = new Procedure();
		int id = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		
		procedure.setProcedureTypeId(service.getProcIdByName(String.valueOf(request.getParameter(ADD_PROCEDURE_SELECTED))));
		procedure.setDetails(request.getParameter(ADD_PROCEDURE_DETAIL).toString());
		procedure.setHistoryId(Integer.valueOf(request.getParameter(HIST_ID)));
		procedure.setDateAssigned(new Date(Calendar.getInstance().getTime().getTime()));
		procedure.setAssignedMedicId(id);

		service.addNewProcedure(procedure);
		request.setAttribute(ADD_RESULT_MSG, ADD_RESULT_KEY);
		
		logger.info(String.format(HISTORY_MESSAGE_ADDED, Integer.valueOf(request.getParameter(HIST_ID))));
		
		return new EditCurrentHistoryTask().execute(request, response);
	}
}
