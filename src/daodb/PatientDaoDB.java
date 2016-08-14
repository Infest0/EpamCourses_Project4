package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import dao.PatientDao;
import enteties.Patient;

/**
 * DAO for patient
 * 
 * @author Nick
 *
 */
public class PatientDaoDB implements PatientDao {
	final static Logger logger = Logger.getLogger(PatientDaoDB.class);

	/**
	 * Creating patients from app is not allowed
	 */
	public void create(Patient e) {
	}

	/**
	 * Updating patients from app is not allowed
	 */
	public boolean update(Patient e) {
		return false;
	}

	/**
	 * Deleting patients from app is not allowed
	 */
	public boolean delete(int id) {
		return false;
	}
	
	/**
	 * Finds patient by its id
	 */
	public Patient find(int id) {
		Patient patient = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sqlPatient = cn.prepareStatement(FIND_PATIENT_BY_ID);
			sqlPatient.setInt(1, id);
			ResultSet patientRes = sqlPatient.executeQuery();

			if (patientRes.next()) {
				patient = new Patient();

				addPatient(patient, patientRes);
			}

			cn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			
			e.printStackTrace();
		}

		return patient;
	}
	
	/**
	 * Find all patients in database
	 */
	public List<Patient> findAll() {
		List<Patient> patients = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet patientRes = cn.prepareStatement(FIND_PATIENTS_ALL).executeQuery();

			if (patientRes.next()) {
				patients = new ArrayList<>();
				addAllPatients(patientRes, patients);
			}

			cn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			
			e.printStackTrace();
		}

		return patients;
	}
	
	/**
	 * Find all patients that have no history 
	 * 	or all histories are discharged
	 */
	public List<Patient> findFreePatients() {
		List<Patient> patients = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet patientRes = cn.prepareStatement(FIND_FREE_PATIENTS).executeQuery();

			if (patientRes.next()) {
				patients = new ArrayList<>();
				addAllPatients(patientRes, patients);
			}

			cn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());

			e.printStackTrace();
		}

		return patients;
	}

	private void addPatient(Patient patient, ResultSet res) throws SQLException {
		patient.setId(res.getInt(PATIENTS_ID));
		patient.setFname(res.getString(PERSON_FNAME));
		patient.setSname(res.getString(PERSON_LNAME));
		patient.setAddress(res.getString(PERSON_ADDRESS));
	}
	
	private void addAllPatients(ResultSet res, List<Patient> patients) throws SQLException {
		res.previous();
		Patient patient = null;
		
		while (res.next()) {
			patient = new Patient();
			addPatient(patient, res);
			patients.add(patient);
		}
	}
}
