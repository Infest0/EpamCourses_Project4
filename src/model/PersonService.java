package model;

import dao.DaoFactory;
import enteties.Person;

/**
 * Grants the interface methods to person DAO in db
 * @author Nick
 *
 */
public class PersonService {
	public Person find(int id) {
		return DaoFactory.getFactory().createPersonDao().find(id);
	}
}
