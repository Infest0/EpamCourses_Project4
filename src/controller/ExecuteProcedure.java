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
import enteties.Procedure;
import enteties.User;
import model.PatientHistoryService;
import model.ProceduresService;

/**
 * Encapsulates executing a procedure function in system
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
		logger.info(PROCEDURE_EXECUTED + procedureId );
		
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
