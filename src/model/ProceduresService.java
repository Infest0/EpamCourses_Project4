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
 * @author Nick
 *
 */
public class ProceduresService {
	public Procedure find(int id) {
		return DaoFactoryDB.getFactory().createProcedureDao().find(id);
	}
	
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

	public void addNewProcedure(Procedure proc) {
		DaoFactory.getFactory().createProcedureDao().create(proc);
	}
	
	public void executeProcedure(Procedure procedure, int medicCurrentId) {
		procedure.setDateExecuted(new Date(Calendar.getInstance().getTime().getTime()));
		procedure.setExecutedMedicId(medicCurrentId);
		new DaoFactoryDB().createProcedureDao().update(procedure);
	}
	
	public int getProcIdByName(String name) {
		return DaoFactory.getFactory().createProcedureDao().getIdByName(name);
	}
}
