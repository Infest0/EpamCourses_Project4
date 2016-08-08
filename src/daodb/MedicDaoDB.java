package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.MedicDao;
import enteties.Medic;

/**
 * DAO for medic
 * 
 * @author Nick
 *
 */
public class MedicDaoDB implements MedicDao {
	/**
	 * Creating medics from app is not allowed
	 */
	public void create(Medic e) {
	}

	/**
	 * Updating medics from app is not allowed
	 */
	public boolean update(Medic e) {
		return false;
	}

	/**
	 * Deleting medics from app is not allowed
	 */
	public boolean delete(int id) {
		return false;
	}

	public Medic find(int id) {
		Medic medic = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sqlMedic = cn.prepareStatement(FIND_MEDIC_BY_ID);
			sqlMedic.setInt(1, id);
			ResultSet medicRes = sqlMedic.executeQuery();

			if (medicRes.next()) {
				medic = new Medic();
				addMedic(medic, medicRes);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return medic;
	}

	public List<Medic> findAll() {
		List<Medic> medics = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			ResultSet medicRes = cn.prepareStatement(FIND_MEDIC_ALL).executeQuery();

			if (medicRes.next()) {
				medics = new ArrayList<>();
				addAllToMedic(medics, medicRes);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return medics;
	}

	 public List<Medic> findAllByPatientHistoryId(int id) {
		List<Medic> medics = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(FIND_ALL_BY_PATIENT_ID);
			preparedStatement.setInt(1, id);
			ResultSet medicRes = preparedStatement.executeQuery();

			if (medicRes.next()) {
				medics = new ArrayList<>();
				addAllToMedic(medics, medicRes);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medics;

	}

	public List<Medic> findAllNotInPatientHistoryById(int id) {
		List<Medic> medics = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement preparedStatement = cn.prepareStatement(FIND_ALL_BY_NOT_PATIENT_ID);
			preparedStatement.setInt(1, id);
			ResultSet medicRes = preparedStatement.executeQuery();

			if (medicRes.next()) {
				medics = new ArrayList<>();
				addAllToMedic(medics, medicRes);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medics;

	}

	private void addAllToMedic(List<Medic> medics, ResultSet medicRes) throws SQLException {
		medicRes.previous();
		Medic medic = null;

		while (medicRes.next()) {
			medic = new Medic();
			addMedic(medic, medicRes);
			medics.add(medic);
		}
	}

	private void addMedic(Medic medic, ResultSet res) throws SQLException {
		medic.setId(res.getInt(MEDIC_PERSON_ID));
		medic.setFname(res.getString(PERSON_FNAME));
		medic.setSname(res.getString(PERSON_LNAME));
		medic.setAddress(res.getString(PERSON_ADDRESS));
		medic.setSpeciality(res.getString(MEDIC_TYPE_NAME));
	}
}
