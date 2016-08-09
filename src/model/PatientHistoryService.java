package model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import dao.DaoFactory;
import dao.PatientHistoryDao;
import enteties.PatientHistory;

/**
 * Grants the interface methods to patient history DAO in db
 * 
 * @author Nick
 */
public class PatientHistoryService {
	public PatientHistory find(int id) {
		PatientHistoryDao patientHistoryDao = DaoFactory.getFactory().createPatientHistoryDao();
		PatientHistory patientHistory = patientHistoryDao.find(id);
		setPatientHistoryData(patientHistory);
		return patientHistory;
	}

	public PatientHistory findByPatientId(int id) {
		List<PatientHistory> histories = DaoFactory.getFactory().createPatientHistoryDao().findByPatientId(id);
		PatientHistory patientHistory = histories.get(histories.size() - 1);
		setPatientHistoryData(patientHistory);
		return patientHistory;
	}

	public List<PatientHistory> findByMedicId(int id) {
		List<PatientHistory> histories = DaoFactory.getFactory().createPatientHistoryDao().findByMedicId(id);

		if (histories != null) {
			for (PatientHistory patientHistory : histories) {
				patientHistory.setPatient(new PatientService().find(patientHistory.getPatientId()));
				setPatientHistoryData(patientHistory);
			}
		}

		return histories;
	}

	public List<PatientHistory> findNotDischanged() {
		List<PatientHistory> histories = DaoFactory.getFactory().createPatientHistoryDao().findNotDischanged();

		if (histories != null) {
			for (PatientHistory patientHistory : histories) {
				patientHistory.setPatient(new PatientService().find(patientHistory.getPatientId()));
				setPatientHistoryData(patientHistory);
			}
		}

		return histories;
	}

	public void updatePatient(PatientHistory patientHistory) {
		DaoFactory daoFactory = DaoFactory.getFactory();
		PatientHistoryDao patientHistoryDao = daoFactory.createPatientHistoryDao();
		patientHistoryDao.update(patientHistory);
	}

	public void addMedicToHistory(int medicId, int historyId) {
		DaoFactory.getFactory().createPatientHistoryDao().addMedicToHistory(medicId, historyId);
	}
	
	public void dischangeByAdmin(int historyId) {
		PatientHistoryDao patientHistoryDaoDB = DaoFactory.getFactory().createPatientHistoryDao();
		PatientHistory patientHistory = patientHistoryDaoDB.find(historyId);
		patientHistory.setDateDischanged(new Date(Calendar.getInstance().getTime().getTime()));
		patientHistoryDaoDB.update(patientHistory);
	}

	private void setPatientHistoryData(PatientHistory patientHistory) {
		patientHistory
				.setPatientHistoryNotes(new PatientHistoryNoteService().findAllByPatientId(patientHistory.getId()));
		patientHistory.setAssignedProcedures(new ProceduresService().findAllByPatientHistoryId(patientHistory.getId()));
	}
}
