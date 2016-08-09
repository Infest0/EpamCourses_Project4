package controller;

import static controller.LogMessages.*;
import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import enteties.Procedure;
import enteties.User;
import model.ProceduresService;

/**
 * Encapsulates executing a procedure function in system
 * 
 * @author Nick
 *
 */
public class ExecuteProcedure implements ITask {
	final static Logger logger = Logger.getLogger(ExecuteProcedure.class);

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProceduresService proceduresService = new ProceduresService();
		int procedureId = Integer.valueOf(request.getParameter(ADD_PROCEDURE_SELECTED));
		Procedure procedure = proceduresService.find(procedureId);
		int id = ((User) request.getSession().getAttribute(SESSION_USER)).getId();
		new ProceduresService().executeProcedure(procedure, id);
		logger.info(String.format(PROCEDURE_EXECUTED, procedureId));
		
		return new EditCurrentHistoryTask().execute(request, response);
	}
}
