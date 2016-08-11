package dao;

import java.util.List;

import enteties.Patient;

/**
 * Interface for patient DAO
 * @author Nick
 *
 */
public interface PatientDao extends GenericDao<Patient> {
	public List<Patient> findFreePatients();
}
