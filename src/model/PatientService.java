package model;

import java.util.List;
import dao.DaoFactory;
import dao.PatientDao;
import enteties.Patient;

/**
 * Grants the interface methods to patient DAO in db
 * 
 * @author Nick
 *
 */
public class PatientService {
	/**
	 * Finds patient by its id in database  
	 * @param id patient id
	 */
	public Patient find(int id) {
		DaoFactory factory = DaoFactory.getFactory();
		PatientDao patientDao = factory.createPatientDao();
		Patient patient = patientDao.find(id);
		return patient;
	}
	
	/**
	 * Returns all patients that have not discharged history 
	 */
	public List<Patient> findFreePatients() {
		return DaoFactory.getFactory().createPatientDao().findFreePatients();
	}
}
