package dao;

import java.util.List;

import enteties.Medic;

public interface MedicDao extends GenericDao<Medic> {
	public List<Medic> findAllByPatientHistoryId(int id);

	public List<Medic> findAllNotInPatientHistoryById(int id);
}
