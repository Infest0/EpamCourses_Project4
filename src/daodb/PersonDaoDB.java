package daodb;

import static daodb.QueryHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PersonDao;
import enteties.Person;
import static daodb.DbNameHandler.*;

/**
 * DAO for person
 * @author Nick
 *
 */
public class PersonDaoDB implements PersonDao {
	/**
	 * Creating persons is not allowed from app
	 */
	public void create(Person e) {
	}

	/**
	 * Updating person user info is not allowed from app
	 */
	public boolean update(Person e) {
		return false;
	}

	/**
	 * Deleting persons from the app is not allowed
	 */
	public boolean delete(int id) {
		return false;
	}
	
	/**
	 * Finds person by its id in database
	 */
	public Person find(int id) {
		Person person = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement statement = cn.prepareStatement(FIND_PERSON_BY_ID);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();

			if (res.next()) {
				person = new Person();
				addPerson(person, res);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}
	
	/**
	 * Find all persons in database
	 */
	public List<Person> findAll() {
		List<Person> persons = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet res = cn.prepareStatement(FIND_PERSON_ALL).executeQuery();

			if (res.next()) {
				persons = new ArrayList<>();
				res.previous();
				Person person = null;

				while (res.next()) {
					person = new Person();
					addPerson(person, res);
				}
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persons;
	}

	private void addPerson(Person person, ResultSet res) throws SQLException {
		person.setId(res.getInt(PERSON_ID));
		person.setFname(res.getString(PERSON_FNAME));
		person.setSname(res.getString(PERSON_LNAME));
		person.setAddress(res.getString(PERSON_ADDRESS));
	}
}
