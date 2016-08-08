package dao;

import daodb.DaoFactoryDB;
import daodb.ProcedureConstraintsDB;

/**
 * Abstract class for Dao Factory implementation
 * @author Nick
 */
public abstract class DaoFactory {
	public abstract PatientHistoryDao createPatientHistoryDao();
	public abstract PatientHistoryNoteDao createPatientHistoryNoteDao();
	public abstract MedicDao createMedicDao();
	public abstract ProcedureDao createProcedureDao();
	public abstract PatientDao createPatientDao();
	public abstract UserDao createUserDao();
	public abstract PersonDao createPersonDao();
	public abstract ProcedureConstraintsDB createRulesDaoDB();
	public abstract AdminDao createAdminDao();
	
	public static DaoFactory getFactory() {
		return new DaoFactoryDB() ;
	}
}
