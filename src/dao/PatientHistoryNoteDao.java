package dao;

import java.util.List;
import enteties.PatientHistoryNote;

/**
 * Main dao interface for patient history note
 * @author Nick
 *
 */
public interface PatientHistoryNoteDao extends GenericDao<PatientHistoryNote> {
	List<PatientHistoryNote> findAllByPatientId(int id);
}
