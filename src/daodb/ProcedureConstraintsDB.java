package daodb;

import static daodb.QueryHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * DAO for procedure constraints
 * @author Nick
 *
 */
public class ProcedureConstraintsDB {
	final static Logger logger = Logger.getLogger(ProcedureConstraintsDB.class);

	/**
	 * Defines constraints by speciality
	 * @param speciality
	 * @return available constraints
	 */
	public List<String> getConstraints(String speciality) {
		List<String> rules = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			String localTableName = "proctype";

			PreparedStatement statement = cn.prepareStatement(FIND_CONSTRAINT_BY_SPECIALITY);

			statement.setString(1, localTableName);
			statement.setString(2, speciality);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				rules = new ArrayList<>();
				resultSet.previous();

				while (resultSet.next()) {
					rules.add(resultSet.getString(localTableName));
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());

			e.printStackTrace();
		}

		return rules;
	}
}