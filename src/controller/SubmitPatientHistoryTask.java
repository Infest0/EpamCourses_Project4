package controller;

import static controller.ControllerParamHandler.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitPatientHistoryTask  implements ITask {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String complaints = request.getParameter(COMPLAINTS);
		int patientId = Integer.valueOf(request.getParameter(SELECTED_PATIENT));
		return "/index.jsp";
	}

}
