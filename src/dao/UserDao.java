package dao;

import enteties.User;

/**
 * Main dao interface for user dao
 * @author Nick
 *
 */
public interface UserDao extends GenericDao<User> {
	public User findByName(String name);
}
