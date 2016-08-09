package controller;

/**
 * Contains all possible tasks in system for factory pattern
 * @author Nick
 *
 */
public enum TaskList {
	SHOW_PATIENT_HISTORY(new ShowCurrentHistoryTask()), 
	SHOW_INFO_ABOUT_ME(new ShowInfoAboutMeTask()),
	SHOW_USER_HISTORIES_MEDIC(new ViewUserHistoriesTask()),
	EDIT_CURRENT_HISTORY(new EditCurrentHistoryTask()), 
	ADD_HISTORY_NOTE(new AddHistoryNoteTask()),
	SUBMIT_HISTORY_NOTE(new SubmitHistoryNoteTask()),
	ADD_PROCEDURE(new AddProcedureTask()),
	SUBMIT_PROCEDURE(new SubmitOperation()),
	OUT_PACIENT(new OutPatientByMedicTask()),
	EXECUTE_PROCEDURE(new ExecuteProcedure()),
	SHOW_NOT_DISCHNAGED(new ShowNotDischangedPatientHistories()),
	MANAGE_HISTORY(new ManageCurrentHistory()),
	ADD_MEDIC_TO_HISTORY(new AddMedicToHistoryTask()),
	ADD_PATIENT_HISTORY(new AddPatientHistoryTask()),
	SUBMIT_PATIENT_HISTORY(new SubmitPatientHistoryTask()),
	OUT_PATIENT_BY_ADMIN(new OutPatientByAdminTask());

	TaskList(ITask task) {
		this.task = task;
	}

	private ITask task;

	public ITask getTask() {
		return task;
	}

	public void setTask(ITask task) {
		this.task = task;
	}
}
