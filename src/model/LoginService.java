package model;

import dao.DaoFactory;
import enteties.User;

/**
 * Class needed for checking match of username and pass
 * @author Nick
 *
 */
public class LoginService {
	/**
	 * Special addition salt number for increasing user password protection level
	 */
	private final String localSalt = "##@sxdadasd";
	
	/**
	 * Checking for matching method
	 * @param usname
	 * @param pass
	 * @return null if not matching and user object if matchs
	 */
	public User checkParameters(String usname, String pass) {
		DaoFactory factory = DaoFactory.getFactory();
		User user =  factory.createUserDao().findByName(usname);
		
		if ((user != null) && hashCode(pass, user.getSalt()) == user.getPassword()) {
			return user;
		}
		
		return null;
	}
	
	/**
	 * Generates hashcode
	 * @param password
	 * @param salt
	 * @return generated hashcode
	 */
	private int hashCode(String password, String salt) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((localSalt == null) ? 0 : localSalt.hashCode());
		return result;
	}
}
