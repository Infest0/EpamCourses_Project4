package dao;

import java.util.List;

import enteties.Patient;

/**
 * Main dao interface for patient
 * @author Nick
 *
 */
public interface PatientDao extends GenericDao<Patient> {
	public List<Patient> findFreePatients();
}
