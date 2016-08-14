package model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import dao.DaoFactory;
import dao.MedicDao;
import daodb.DaoFactoryDB;
import enteties.Procedure;

/**
 * Grants the interface methods to procedure DAO in db
 * 
 * @author Nick
 *
 */
public class ProceduresService {
	/**
	 * Finds procedure by its id in daabase
	 * 
	 * @param id
	 *            procedure id in database
	 */
	public Procedure find(int id) {
		return DaoFactoryDB.getFactory().createProcedureDao().find(id);
	}

	/**
	 * Finds all assigned procedures to patient history
	 * 
	 * @param id
	 *            patient history id
	 */
	public List<Procedure> findAllByPatientHistoryId(int id) {
		List<Procedure> procedures = DaoFactory.getFactory().createProcedureDao().findAllByPatientId(id);
		MedicDao medicDao = DaoFactory.getFactory().createMedicDao();

		if (procedures != null) {
			for (Procedure procedure : procedures) {
				procedure.setAssignedMedic(medicDao.find(procedure.getAssignedMedicId()));

				if (procedure.getExecutedMedicId() != 0) {
					procedure.setExecutedMedic(medicDao.find(procedure.getExecutedMedicId()));
				}
			}
		}

		return procedures;
	}

	/**
	 * Adds new procedure to database
	 */
	public void addNewProcedure(Procedure proc) {
		DaoFactory.getFactory().createProcedureDao().create(proc);
	}

	/**
	 * Sets the date executed to current date
	 * 
	 * @param procedure
	 *            procedure id
	 * @param medicCurrentId
	 *            medic id
	 */
	public void executeProcedure(Procedure procedure, int medicCurrentId) {
		procedure.setDateExecuted(new Date(Calendar.getInstance().getTime().getTime()));
		procedure.setExecutedMedicId(medicCurrentId);
		new DaoFactoryDB().createProcedureDao().update(procedure);
	}

	/**
	 * Returns procedure id by its id
	 * 
	 * @param name
	 *            procedure type string
	 */
	public int getProcIdByName(String name) {
		return DaoFactory.getFactory().createProcedureDao().getIdByName(name);
	}
}
