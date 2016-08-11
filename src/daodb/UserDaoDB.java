package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.UserDao;
import enteties.User;

/**
 * DAO for user
 * @author Nick
 *
 */
public class UserDaoDB implements UserDao {
	/**
	 * Creating users from this module is not allowed due to protection measures
	 */
	public void create(User e) {
	}

	/**
	 * Updating users from this module is not allowed due to protection measures
	 */
	public boolean update(User e) {
		return false;
	}

	/**
	 * Deleting users from this module is not allowed due to protection measures
	 */
	public boolean delete(int id) {
		return false;
	}

	public User find(int id) {
		User user = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(FIND_USER_BY_ID);
			sql.setInt(1, id);
			ResultSet res = sql.executeQuery();

			if (res.next()) {
				user = new User();
				initUserField(user, res);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> findAll() {
		List<User> users = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet res = cn.prepareStatement(FIND_USER_ALL).executeQuery();

			if (res.next()) {
				users = new ArrayList<>();
				User user = null;
				res.previous();

				while (res.next()) {
					user = new User();
					initUserField(user, res);
					users.add(user);
				}
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	/**
	 * Find user by username
	 */
	public User findByName(String name) {
		User user = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sql = cn.prepareStatement(FIND_USER_BY_NAME);
			sql.setString(1, name);
			ResultSet res = sql.executeQuery();

			if (res.next()) {
				user = new User();
				initUserField(user, res);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	private void initUserField(User user, ResultSet res) throws SQLException {
		user.setId(res.getInt(LOG_PERSON_ID));
		user.setPassword(res.getInt(LOG_PASSWORD));
		user.setSalt(res.getString(LOG_SALT));
		user.setUsername(res.getString(LOG_USERNAME));
	}
}
