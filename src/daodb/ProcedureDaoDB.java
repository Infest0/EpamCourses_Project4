package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.ProcedureDao;
import enteties.Procedure;

/**
 * DAO for procedure
 * @author Nick
 *
 */
public class ProcedureDaoDB implements ProcedureDao {
	/**
	 * Creates a procedure in database
	 * @param Procedure  input procedure object,
	 *  takes fields from current object
	 */
	public void create(Procedure e) {
		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_PROCEDURE);
			preparedStatement.setInt(1, e.getProcedureTypeId());
			preparedStatement.setInt(2, e.getHistoryId());
			preparedStatement.setInt(3, e.getAssignedMedicId());
			preparedStatement.setDate(4, e.getDateAssigned());
			preparedStatement.setString(5, e.getDetails());
			preparedStatement.executeUpdate();

			cn.close();
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * Updates a procedure in database
	 * @param Procedure  input procedure object,
	 *  takes fields from current object
	 */
	public boolean update(Procedure e) {
		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement statement = cn.prepareStatement(UPDATE_PROCEDURE);
			UpdateProcedureSql(statement, e);
			System.out.println(UPDATE_PROCEDURE);
			statement.executeUpdate();
			cn.close();
			return true;
		} catch (SQLException er) {
			er.printStackTrace();
		}
		return false;
	}

	/**
	 * There is no ability to delete procedures in app
	 */
	public boolean delete(int id) {
		return false;
	}
	
	/**
	 * Finds a procedure by its id
	 */
	public Procedure find(int id) {
		Procedure procedure = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement statement = cn.prepareStatement(FIND_PROCEDURE_BY_ID);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();

			if (res.next()) {
				procedure = new Procedure();
				addProcedure(procedure, res);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return procedure;
	}
	
	/**
	 * Finds all procedures in system
	 */
	public List<Procedure> findAll() {
		List<Procedure> patientHistoryNoteList = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet rs = cn.prepareStatement(FIND_PROCEDURE_ALL).executeQuery();

			if (rs.next()) {
				Procedure procedure = null;
				patientHistoryNoteList = new ArrayList<>();
				rs.previous();

				while (rs.next()) {
					procedure = new Procedure();
					addProcedure(procedure, rs);
					patientHistoryNoteList.add(procedure);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistoryNoteList;
	}
	
	/**
	 * Finds all procedures by patient id
	 */
	public List<Procedure> findAllByPatientId(int id) {
		List<Procedure> patientHistoryNoteList = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(FIND_PROCEDURE_BY_PATID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Procedure procedure = null;
				patientHistoryNoteList = new ArrayList<>();
				rs.previous();

				while (rs.next()) {
					procedure = new Procedure();
					addProcedure(procedure, rs);
					patientHistoryNoteList.add(procedure);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientHistoryNoteList;
	}
	
	/**
	 * Get the procedure type by its name
	 */
	public int getIdByName(String name) {
		int foundId = -1;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sqlPatient = cn.prepareStatement(FIND_PROCTYPE_ID_BY_NAME);
			sqlPatient.setString(1, name);
			ResultSet procedureRes = sqlPatient.executeQuery();

			if (procedureRes.next()) {
				foundId = procedureRes.getInt(PROCEDURE_TYPE_ID);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foundId;
	}

	private void addProcedure(Procedure proc, ResultSet res) throws SQLException {
		proc.setId(res.getInt(PROCEDURE_ID));
		proc.setHistoryId(res.getInt(PROCEDURE_HISTORY));
		proc.setType(res.getString(PROCEDURE_TYPE_NAME));
		proc.setDateAssigned(res.getDate(PROCEDURE_DATE_ASSIGNED));
		proc.setDateExecuted(res.getDate(PROCEDURE_DATE_EXECUTED));
		proc.setAssignedMedicId(res.getInt(PROCEDURE_ASSIGNED_MEDIC));
		proc.setExecutedMedicId(res.getInt(PROCEDURE_EXECUTED_MEDIC));
		proc.setDetails(res.getString(PROCEDURE_DETAILS));
		proc.setProcedureTypeId(res.getInt(PROCEDURE_ID_TYPE));
	}

	private void UpdateProcedureSql(PreparedStatement preparedStatement, Procedure procedure) throws SQLException {
		preparedStatement.setInt(1, procedure.getProcedureTypeId());
		preparedStatement.setInt(2, procedure.getHistoryId());
		preparedStatement.setInt(3, procedure.getAssignedMedicId());
		preparedStatement.setInt(4, procedure.getExecutedMedicId());
		preparedStatement.setDate(5, procedure.getDateExecuted());
		preparedStatement.setDate(6, procedure.getDateAssigned());
		preparedStatement.setString(7, procedure.getDetails());
		preparedStatement.setInt(8, procedure.getId());
	}
}
