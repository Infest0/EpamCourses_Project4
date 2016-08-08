package daodb;

import java.sql.Connection;
import static daodb.DbNameHandler.*;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import dao.AdminDao;
import dao.DaoFactory;
import dao.MedicDao;
import dao.PatientDao;
import dao.PatientHistoryDao;
import dao.PatientHistoryNoteDao;
import dao.PersonDao;
import dao.ProcedureDao;
import dao.UserDao;
import javax.sql.DataSource;

/**
 * Factory fao DAO 
 * @author Nick
 *
 */
public class DaoFactoryDB extends DaoFactory {
	private static DataSource dataSource;

	public DaoFactoryDB() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup(JNDI_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public PatientHistoryDao createPatientHistoryDao() {
		return new PatientHistoryDaoDB();
	}

	public static synchronized Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public PatientHistoryNoteDao createPatientHistoryNoteDao() {
		return new PatientHistoryNoteDaoDB();
	}

	public ProcedureDao createProcedureDao() {
		return new ProcedureDaoDB();
	}

	public PatientDao createPatientDao() {
		return new PatientDaoDB();
	}

	public MedicDao createMedicDao() {
		return new MedicDaoDB();
	}

	public UserDao createUserDao() {
		return new UserDaoDB();
	}

	public PersonDao createPersonDao() {
		return new PersonDaoDB();
	}

	public ProcedureConstraintsDB createRulesDaoDB() {
		return new ProcedureConstraintsDB();
	}

	public AdminDao createAdminDao() {
		return new AdminDaoDB();
	}
}
