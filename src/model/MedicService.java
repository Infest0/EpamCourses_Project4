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
	public Medic find(int id) {
		return DaoFactory.getFactory().createMedicDao().find(id);
	}

	public List<Medic> findAllByPatientHistoryId(int id) {
		return DaoFactory.getFactory().createMedicDao().findAllByPatientHistoryId(id);
	}
	
	public List<Medic> findAllNotInPatientHistoryById(int id) {
		return DaoFactory.getFactory().createMedicDao().findAllNotInPatientHistoryById(id);
	}
	
	public void outHistoriesById(int id) {
		DaoFactory.getFactory().createMedicDao().outHistoriesById(id);
	}
}
