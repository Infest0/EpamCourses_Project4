package daodb;

import static daodb.QueryHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for procedure constraints
 * @author Nick
 *
 */
public class ProcedureConstraintsDB {
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
			e.printStackTrace();
		}

		return rules;
	}
}