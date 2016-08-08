package dao;

import java.sql.Date;
import java.util.List;
import enteties.PatientHistory;

/**
 * Main dao interface for patient history
 * 
 * @author Nick
 *
 */
public interface PatientHistoryDao extends GenericDao<PatientHistory> {
	public List<PatientHistory> findByPatientId(int id);

	public List<PatientHistory> findByMedicId(int id);

	public List<PatientHistory> findNotDischanged();

	public void dischangeByMedic(int medicId, int historyId);

	void addMedicToHistory(int medicId, int historyId);
	
	void addPatientHistory(int patientId, String complaints, Date dateAdded);
}
