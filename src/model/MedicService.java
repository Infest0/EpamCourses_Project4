package model;

import java.util.List;

import dao.DaoFactory;
import enteties.Medic;

/**
 * Grants the interface methods to medic DAO in db
 * 
 * @author Nick
 *
 */
public class MedicService {
	
	/**
	 * Finds medic in database by its id
	 * @param id medic id in database
	 */
	public Medic find(int id) {
		return DaoFactory.getFactory().createMedicDao().find(id);
	}

	/**
	 * Find all medics assigned to patient history
	 * @param id patient history id
	 */
	public List<Medic> findAllByPatientHistoryId(int id) {
		return DaoFactory.getFactory().createMedicDao().findAllByPatientHistoryId(id);
	}
	
	/**
	 * Find all medics that are assigned to patient history
	 * @param id patient history id
	 */
	public List<Medic> findAllNotInPatientHistoryById(int id) {
		return DaoFactory.getFactory().createMedicDao().findAllNotInPatientHistoryById(id);
	}
	
	/**
	 * Deletes medic from patient history medic list
	 * @param id medic id
	 */
	public void outHistoriesById(int id) {
		DaoFactory.getFactory().createMedicDao().outHistoriesById(id);
	}
}
