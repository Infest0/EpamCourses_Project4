package model;

import dao.DaoFactory;
import enteties.Person;

/**
 * Grants the interface methods to person DAO in database
 * @author Nick
 *
 */
public class PersonService {
	
	/**
	 * Find person by its id in database
	 * @param id - person id in database
	 * @return
	 */
	public Person find(int id) {
		return DaoFactory.getFactory().createPersonDao().find(id);
	}
}
