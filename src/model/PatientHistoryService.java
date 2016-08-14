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
	
	/**
	 * Find patient history by its id
	 * @param id - id in database
	 */
	public PatientHistory find(int id) {
		PatientHistoryDao patientHistoryDao = DaoFactory.getFactory().createPatientHistoryDao();
		PatientHistory patientHistory = patientHistoryDao.find(id);
		setPatientHistoryData(patientHistory);
		return patientHistory;
	}
	
	/**
	 * Finds patient history by its id
	 * @param id patient history id
	 */
	public PatientHistory findByPatientId(int id) {
		List<PatientHistory> histories = DaoFactory.getFactory().createPatientHistoryDao().findByPatientId(id);
		PatientHistory patientHistory = null;

		 if (histories != null && histories.size() > 0) {
			patientHistory = histories.get(histories.size() - 1);
			setPatientHistoryData(patientHistory);
		}

		return patientHistory;
	}
	
	/**
	 * Finds all patient histories assigned to medic
	 * @param id medic id
	 */
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
	
	/**
	 * Find all patient histories that are not discharged
	 */
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
	
	/**
	 * 
	 * @param patientHistory
	 */
	public void updatePatient(PatientHistory patientHistory) {
		DaoFactory daoFactory = DaoFactory.getFactory();
		PatientHistoryDao patientHistoryDao = daoFactory.createPatientHistoryDao();
		patientHistoryDao.update(patientHistory);
	}
	
	/**
	 * Assigns medic to patient history
	 * @param medicId medic id int
	 * @param historyId history patient id int
	 */
	public void addMedicToHistory(int medicId, int historyId) {
		DaoFactory.getFactory().createPatientHistoryDao().addMedicToHistory(medicId, historyId);
	}
	
	/**
	 * Sets the date discharged and deletes all medics from patient history medic list
	 * @param historyId 
	 */
	public void dischangeByAdmin(int historyId) {
		PatientHistoryDao patientHistoryDaoDB = DaoFactory.getFactory().createPatientHistoryDao();
		PatientHistory patientHistory = patientHistoryDaoDB.find(historyId);
		patientHistory.setDateDischanged(new Date(Calendar.getInstance().getTime().getTime()));
		patientHistoryDaoDB.update(patientHistory);
	}
	
	private void setPatientHistoryData(PatientHistory patientHistory) {
		patientHistory.setPatientHistoryNotes(new PatientHistoryNoteService().findAllByPatientId(patientHistory.getId()));
		patientHistory.setAssignedProcedures(new ProceduresService().findAllByPatientHistoryId(patientHistory.getId()));
	}
}
