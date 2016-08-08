package model;

import java.util.List;
import dao.DaoFactory;
import dao.PatientHistoryNoteDao;
import daodb.DaoFactoryDB;
import enteties.PatientHistoryNote;

/**
 * Grants the interface methods to patient history note DAO in db
 * @author Nick
 *
 */
public class PatientHistoryNoteService {
	public void addNewHistory(String theme, String text, int patHistId) {
		PatientHistoryNoteDao factory = DaoFactory.getFactory().createPatientHistoryNoteDao();
		PatientHistoryNote historyNote = new PatientHistoryNote();
		historyNote.setHistoryId(patHistId);
		historyNote.setTheme(theme);
		historyNote.setText(text);
		factory.create(historyNote);
	}
	
	public PatientHistoryNote find(int id) {
		DaoFactory factory = DaoFactoryDB.getFactory();
		PatientHistoryNoteDao patHistNote = factory.createPatientHistoryNoteDao();
		return patHistNote.find(id);
	}

	public List<PatientHistoryNote> findAllByPatientId(int id) {
		DaoFactory dao = DaoFactory.getFactory();
		PatientHistoryNoteDao patientHistoryNoteDao = dao.createPatientHistoryNoteDao();
		return patientHistoryNoteDao.findAllByPatientId(id);
	}
}
