package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PatientHistoryDao;
import enteties.PatientHistory;

/**
 * DAO for patient history
 * 
 * @author Nick
 *
 */
public class PatientHistoryDaoDB implements PatientHistoryDao {
	public void create(PatientHistory patientHistory) {
	}

	public boolean update(PatientHistory e) {
		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(UPDATE_PATHIST);
			UpdatePatientInitSql(sql, e);
			sql.executeUpdate();
			cn.close();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	/**
	 * Deleting patient history is not allowed in app
	 */
	public boolean delete(int id) {
		return false;
	}

	public PatientHistory find(int id) {
		PatientHistory patientHistory = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(FIND_PATHIST_BY_ID);
			sql.setInt(1, id);
			ResultSet res = sql.executeQuery();

			if (res.next()) {
				patientHistory = new PatientHistory();
				addPatient(res, patientHistory);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistory;
	}

	public List<PatientHistory> findAll() {
		List<PatientHistory> patientHistories = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet res = cn.prepareStatement(FIND_PATHIST_BY_ID).executeQuery();
			patientHistories = new ArrayList<>();
			addAllToResult(res, patientHistories);
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistories;
	}

	/**
	 * Find history by patient id
	 */
	public List<PatientHistory> findByPatientId(int id) {
		List<PatientHistory> patientHistories = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(FIND_PATHIST_BY_PATIENT_ID);
			sql.setInt(1, id);
			ResultSet res = sql.executeQuery();
			patientHistories = new ArrayList<>();
			addAllToResult(res, patientHistories);
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistories;
	}

	/**
	 * Find history by medic id
	 */
	public List<PatientHistory> findByMedicId(int id) {
		List<PatientHistory> patientHistories = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(FIND_PATHIST_BY_MEDIC_ID);
			sql.setInt(1, id);
			ResultSet res = sql.executeQuery();
			patientHistories = new ArrayList<>();
			addAllToResult(res, patientHistories);
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistories;
	}

	public List<PatientHistory> findNotDischanged() {
		List<PatientHistory> patientHistories = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet res = cn.prepareStatement(FIND_PATHIST_NOT_DISCHANGED).executeQuery();
			patientHistories = new ArrayList<>();
			addAllToResult(res, patientHistories);
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistories;
	}

	private void addAllToResult(ResultSet res, List<PatientHistory> patientHistories) throws SQLException {
		if (res.next()) {
			PatientHistory patientHistory = null;
			res.previous();

			while (res.next()) {
				patientHistory = new PatientHistory();
				addPatient(res, patientHistory);
				patientHistories.add(patientHistory);
			}
		}
	}

	private void addPatient(ResultSet res, PatientHistory patientHistory) throws SQLException {
		patientHistory.setComplaints(res.getString(PATIENT_HISTORY_COMPLAINTS));
		patientHistory.setDateAdded(res.getDate(PATIENT_HISTORY_DATE_ADDED));
		patientHistory.setDateDischanged(res.getDate(PATIENT_HISTORY_DATE_DISCHANGED));
		patientHistory.setId(res.getInt(PATIENT_HISTORY_ID));
		patientHistory.setPatientId(res.getInt(PATIENT_HISTORY_PAT_ID));
	}

	public void addMedicToHistory(int medicId, int historyId) {
		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement statement = cn.prepareStatement(ADD_MEDIC_TO_PATHIST);
			statement.setInt(1, medicId);
			statement.setInt(2, historyId);
			statement.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void UpdatePatientInitSql(PreparedStatement preparedStatement, PatientHistory patientHistory)
			throws SQLException {
		preparedStatement.setInt(1, patientHistory.getId());
		preparedStatement.setInt(2, patientHistory.getPatientId());
		preparedStatement.setString(3, patientHistory.getComplaints());
		preparedStatement.setDate(4, patientHistory.getDateAdded());
		preparedStatement.setDate(5, patientHistory.getDateDischanged());
		preparedStatement.setInt(6, patientHistory.getId());
	}

	public void dischangeByMedic(int medicId, int historyId) {
		try (Connection cn = DaoFactoryDB.getConnection()) {

			PreparedStatement preparedStatement = cn.prepareStatement(DISCHARGE_PATIENT);
			preparedStatement.setInt(1, medicId);
			preparedStatement.setInt(2, historyId);
			preparedStatement.executeUpdate();

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPatientHistory(int patientId, String complaints, Date dateAdded) {
		// TODO Auto-generated method stub
		
	}
}
