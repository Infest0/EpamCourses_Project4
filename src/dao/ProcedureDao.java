package dao;

import java.util.List;
import enteties.Procedure;

/**
 * Main dao interface for procedure dao
 * @author Nick
 *
 */
public interface ProcedureDao extends GenericDao<Procedure> {
	 List<Procedure> findAllByPatientId(int id);
	 int getIdByName(String name);
}
