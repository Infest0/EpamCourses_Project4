package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import dao.PatientHistoryNoteDao;
import enteties.PatientHistoryNote;

/**
 * DAO for patient history note
 * 
 * @author Nick
 *
 */
public class PatientHistoryNoteDaoDB implements PatientHistoryNoteDao {
	final static Logger logger = Logger.getLogger(PatientHistoryNoteDao.class);

	/**
	 * Creates a new patient history note
	 * 
	 * @param PatientHistoryNote
	 *            input patient history note object, takes fields from current
	 *            object
	 */
	public void create(PatientHistoryNote e) {
		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_PATHISTNOTE);

			preparedStatement.setString(1, e.getTheme());
			preparedStatement.setDate(2, new Date(Calendar.getInstance().getTime().getTime()));
			preparedStatement.setString(3, e.getText());
			preparedStatement.setInt(4, e.getHistoryId());
			preparedStatement.executeUpdate();

			cn.close();
		} catch (SQLException err) {
			logger.error(err.getMessage());

			err.printStackTrace();
		}
	}

	/**
	 * There is no need in update user history notes
	 */
	public boolean update(PatientHistoryNote e) {
		return false;
	}

	/**
	 * Deleting history notes are not allowed in app
	 */
	public boolean delete(int id) {
		return false;
	}

	/**
	 * Finds patient history note by its id
	 */
	public PatientHistoryNote find(int id) {
		PatientHistoryNote patientHistoryNote = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sqlPatient = cn.prepareStatement(FIND_PATIENT_BY_ID);
			sqlPatient.setInt(1, id);
			ResultSet patientRes = sqlPatient.executeQuery();

			if (patientRes.next()) {
				patientHistoryNote = new PatientHistoryNote();
				addPatientNote(patientHistoryNote, patientRes);
			}

			cn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());

			e.printStackTrace();
		}

		return patientHistoryNote;
	}

	/**
	 * Finds all patient history notes in system
	 */
	public List<PatientHistoryNote> findAll() {
		List<PatientHistoryNote> patientHistoryNoteList = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet rs = cn.prepareStatement(FIND_PATHISTNOTE_ALL).executeQuery();

			if (rs.next()) {
				patientHistoryNoteList = new ArrayList<>();
				addAllToProcedure(rs, patientHistoryNoteList);
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());

			e.printStackTrace();
		}

		return patientHistoryNoteList;
	}

	/**
	 * Find patient history notes by patient id
	 */
	public List<PatientHistoryNote> findAllByPatientId(int id) {
		List<PatientHistoryNote> patientHistoryNoteList = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(FIND_PATHISTNOTE_BY_PATID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				patientHistoryNoteList = new ArrayList<>();
				addAllToProcedure(rs, patientHistoryNoteList);
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());

			e.printStackTrace();
		}

		return patientHistoryNoteList;
	}

	private void addAllToProcedure(ResultSet res, List<PatientHistoryNote> patientHistoryNotes) throws SQLException {
		res.previous();

		while (res.next()) {
			PatientHistoryNote patientHistoryNote = new PatientHistoryNote();
			addPatientNote(patientHistoryNote, res);
			patientHistoryNotes.add(patientHistoryNote);
		}
	}

	private void addPatientNote(PatientHistoryNote patientHistoryNote, ResultSet rs) throws SQLException {
		patientHistoryNote.setText(rs.getString(HISTORY_NOTES_TEXT));
		patientHistoryNote.setTheme(rs.getString(HISTORY_NOTES_THEME));
		patientHistoryNote.setDate(rs.getDate(HISTORY_NOTES_DATE));
		patientHistoryNote.setId(rs.getInt(HISTORY_NOTES_ID));
		patientHistoryNote.setHistoryId(rs.getInt(HISTORY_NOTES_PAT_ID));
	}
}
