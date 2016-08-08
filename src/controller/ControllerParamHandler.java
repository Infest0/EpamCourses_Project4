package controller;

/**
 * Contains all params on controller layer
 */
public class ControllerParamHandler {
	/**
	 * Edit current history
	 */
	public final static String EDIT_HISTORY_PATH = "/jsp/edithistory.jsp";
	public final static String HIST_ID = "histId";
	public final static String PAT_HIST_REQ = "SHOW_PATIENT_HISTORY";
	public final static String EDIT_CUR_REQ = "EDIT_CURRENT_HISTORY";
	public final static String HISTORY_NOTE_REQ = "ADD_HISTORY_NOTE";
	public final static String PROCEDURE_REQ = "ADD_PROCEDURE";
	public final static String SHOW_NOT_DISCHANGED = "SHOW_NOT_DISCHNAGED";
	public final static String HISTORIES_OPEN_MEDIC = "EDIT_CURRENT_HISTORY";
	public final static String OPEN_HISTORIES_ACTION = "openhist";
	public final static String HISTORIES_OPEN_ADMIN = "MANAGE_HISTORY";
	public final static String OUT_REQ = "OUT_PACIENT";
	public final static String OUT_KEY = "text.outresult";
	public final static String EXECUTE_PROCEDURE = "EXECUTE_PROCEDURE";
	public final static String VIEW_ALL_PATIENTS_PATH = "/jsp/allpatients.jsp";
	public final static String MANAGE_CURRENT_HISTORY_PATH = "/jsp/managehistory.jsp";
	public final static String HISTORY_MEDICS = "history_medics";
	public final static String HISTORY_AVAILABLE_MEDICS = "available_medics";
	public final static String ADD_MEDIC_TO_HISTORY = "ADD_MEDIC_TO_HISTORY";
	public final static String FREE_PATIENTS = "free_patients";
	public final static String ADD_PATHIST_PATH = "/jsp/addpatienthistory.jsp";
	public final static String ADD_PATHIST = "ADD_PATIENT_HISTORY";
	public final static String COMPLAINTS = "patient_omplaints";
	public final static String SUBMIT_PATHIST = "SUBMIT_PATIENT_HISTORY";
	public final static String SELECTED_PATIENT = "selectedPatient";

	public String getSELECTED_PATIENT() {
		return SELECTED_PATIENT;
	}
	
	public String getSUBMIT_PATHIST() {
		return SUBMIT_PATHIST;
	}

	public String getCOMPLAINTS() {
		return COMPLAINTS;
	}

	public String getADD_PATHIST() {
		return ADD_PATHIST;
	}

	public String getFREE_PATIENTS() {
		return FREE_PATIENTS;
	}

	public String getADD_MEDIC_TO_HISTORY() {
		return ADD_MEDIC_TO_HISTORY;
	}

	public String getHISTORY_AVAILABLE_MEDICS() {
		return HISTORY_AVAILABLE_MEDICS;
	}

	public String getHISTORY_MEDICS() {
		return HISTORY_MEDICS;
	}

	public String getOPEN_HISTORIES_ACTION() {
		return OPEN_HISTORIES_ACTION;
	}

	public String getSHOW_NOT_DISCHANGED() {
		return SHOW_NOT_DISCHANGED;
	}

	public String getPAT_HIST_REQ() {
		return PAT_HIST_REQ;
	}

	public String getHIST_ID() {
		return HIST_ID;
	}

	public String getEDIT_CUR_REQ() {
		return EDIT_CUR_REQ;
	}

	public String getHISTORY_NOTE_REQ() {
		return HISTORY_NOTE_REQ;
	}

	public String getADD_PROCEDURE() {
		return ADD_PROCEDURE_REQ;
	}

	public String getPROCEDURE_REQ() {
		return PROCEDURE_REQ;
	}

	public String getOUT_REQ() {
		return OUT_REQ;
	}

	public String getOUT_KEY() {
		return OUT_KEY;
	}

	public String getEXECUTE_PROCEDURE() {
		return EXECUTE_PROCEDURE;
	}

	/**
	 * Index params
	 */
	public final static String INDEX_PATH = "/index.jsp";
	public final static String PARAM_PATH = "params.text";

	public String getINDEX_PATH() {
		return INDEX_PATH;
	}

	public String getPARAM_PATH() {
		return PARAM_PATH;
	}

	/**
	 * Add procedure and operation tasks
	 */
	public final static String ADD_RESULT = "/jsp/result.jsp";

	public String getAddResult() {
		return ADD_RESULT;
	}

	public final static String ADD_PROCEDURE_PATH = "/jsp/addProcedure.jsp";
	public final static String ADD_PROCEDURE_RULES = "rules";
	public final static String ADD_PROCEDURE_ID = "id";
	public final static String ADD_PROCEDURE_PROCEDURES = "procedures";
	public final static String ADD_PROCEDURE_SELECTED = "procname";
	public final static String ADD_PROCEDURE_REQ = "SUBMIT_PROCEDURE";
	public final static String ADD_RESULT_MSG = "resultMsg";
	public final static String ADD_RESULT_KEY = "text.addprocresult";
	public final static String ADD_PROCEDURE_DETAIL = "details";
	public final static String SELECTED_MEDIC = "selected_medic";

	public String getSELECTED_MEDIC() {
		return SELECTED_MEDIC;
	}

	public String getADD_PROCEDURE_PROCEDURES() {
		return ADD_PROCEDURE_PROCEDURES;
	}

	public String getADD_PROCEDURE_SELECTED() {
		return ADD_PROCEDURE_SELECTED;
	}

	public String getADD_PROCEDURE_REQ() {
		return ADD_PROCEDURE_REQ;
	}

	public String getADD_RESULT_MSG() {
		return ADD_RESULT_MSG;
	}

	public String getADD_RESULT_KEY() {
		return ADD_RESULT_KEY;
	}

	public String getADD_PROCEDURE_DETAIL() {
		return ADD_PROCEDURE_DETAIL;
	}

	public final static String ADD_HISTORY_TEXT = "text";
	public final static String ADD_HISTORY_THEME = "theme";
	public final static String HISTORY_NOTE_PATH = "/jsp/addHistoryNote.jsp";
	public final static String ADD_NOTE_RESULT = "text.historynote";
	public final static String ADD_HISTORY_NOTE_REQ = "SUBMIT_HISTORY_NOTE";

	public String getADD_HISTORY_NOTE_REQ() {
		return ADD_HISTORY_NOTE_REQ;
	}

	public String getADD_HISTORY_TEXT() {
		return ADD_HISTORY_TEXT;
	}

	public String getADD_HISTORY_THEME() {
		return ADD_HISTORY_THEME;
	}

	public String getHISTORY_NOTE_PATHh() {
		return HISTORY_NOTE_PATH;
	}

	/**
	 * Login params
	 */
	public final static String LOGIN_PATH = "/login.jsp";
	public final static String LOGIN_USNAME = "usname";
	public final static String LOGIN_PASS = "pass";

	public String getLOGIN_PATH() {
		return LOGIN_PATH;
	}

	public String getLOGIN_USNAME() {
		return LOGIN_USNAME;
	}

	public String getLOGIN_PASS() {
		return LOGIN_PASS;
	}

	/**
	 * Show all histories task
	 */
	public final static String HISTORIES_PATH = "/jsp/medichistories.jsp";
	public final static String HISTORIES_LIST = "histories";
	public final static String HISTORIES_REQ = "SHOW_USER_HISTORIES_MEDIC";

	public String getHISTORIES_PATH() {
		return HISTORIES_PATH;
	}

	public String getHISTORIES_LIST() {
		return HISTORIES_LIST;
	}

	public String getHISTORIES_REQ() {
		return HISTORIES_REQ;
	}

	/**
	 * Session params
	 */
	public final static String SESSION_ROLE = "role";
	public final static String SESSION_USER = "user";
	public final static String SESSION_RULES = "rules";
	public final static String SESSION_LANGUAGE = "language";

	public String getSESSION_LANGUAGE() {
		return SESSION_LANGUAGE;
	}

	public String getSESSION_ROLE() {
		return SESSION_ROLE;
	}

	public String SESSION_USER() {
		return SESSION_USER;
	}

	public String getSESSION_RULES() {
		return SESSION_RULES;
	}

	/**
	 * Show user info
	 */
	public final static String ME_INFO_PERSON = "person";
	public final static String ME_INFO_PATH = "/jsp/meinfo.jsp";
	public final static String ME_INFO_REQ = "SHOW_INFO_ABOUT_ME";

	public String getME_INFO_PERSON() {
		return ME_INFO_PERSON;
	}

	public String getME_INFO_PATH() {
		return ME_INFO_PATH;
	}

	public String getME_INFO_REQ() {
		return ME_INFO_REQ;
	}

	/**
	 * Show my ill history
	 */
	public final static String MY_HISTORY_PATH = "/jsp/mehistory.jsp";
	public final static String MY_HISTORY_NOTES = "history";
	public final static String MY_HISTORY_PROCEDURES = "procedures";

	public String getMY_HISTORY_PATH() {
		return MY_HISTORY_PATH;
	}

	public String getMY_HISTORY_NOTES() {
		return MY_HISTORY_NOTES;
	}

	public String getMY_HISTORY_PROCEDURES() {
		return MY_HISTORY_PROCEDURES;
	}

	/**
	 * Command param
	 */
	public final static String COMMAND_PARAM = "command";

	/**
	 * SERVLET ANNOTATION PARAMS
	 */
	public final static String LOGIN_ANNOTATION = "/LoginServlet";
	public final static String LOGOUT_ANNOTATION = "/LogoutServlet";
	public final static String CONTROLLER_ANNOTATION = "/Controller";

	/**
	 * JS PARAMS
	 */
	public final static String JS_REQ = "Controller?";
	public final static String JS_FUNC = "PageRecive";
	public final static String JS_GET = "AjaxGet";

	public String getJS_REQ() {
		return JS_REQ;
	}

	public String getJS_FUNC() {
		return JS_FUNC;
	}

	public String getJS_GET() {
		return JS_GET;
	}
}
