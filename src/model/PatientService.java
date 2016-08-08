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
	public Patient find(int id) {
		DaoFactory factory = DaoFactory.getFactory();
		PatientDao patientDao = factory.createPatientDao();
		Patient patient = patientDao.find(id);
		return patient;
	}
	
	public List<Patient> findFreePatients() {
		return DaoFactory.getFactory().createPatientDao().findFreePatients();
	}
}
