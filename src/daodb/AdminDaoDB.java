package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import dao.AdminDao;
import enteties.Admin;

/**
 * DAO for admin
 * 
 * @author Nick
 *
 */
public class AdminDaoDB implements AdminDao {
	final static Logger logger = Logger.getLogger(AdminDao.class);
	
	/**
	 * Creating admin is not allowed in current system
	 */
	public void create(Admin e) {
	}

	/**
	 * Updating admin is not allowed in current system
	 */
	public boolean update(Admin e) {
		return false;
	}
	
	/**
	 * Deleting admin is not allowed in current system
	 */
	public boolean delete(int id) {
		return false;
	}
	
	/**
	 * Finds admin by its id
	 */
	public Admin find(int id) {
		Admin admin = null;

		try (Connection cn = DaoFactoryDB.getConnection()) {
			PreparedStatement sqlMedic = cn.prepareStatement(FIND_ADMIN_BY_ID);
			sqlMedic.setInt(1, id);
			ResultSet medicRes = sqlMedic.executeQuery();

			 if (medicRes.next()) {
				admin = new Admin();

				addAdmin(admin, medicRes);
			}

			cn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return admin;
	}
	
	/**
	 * Finding all admins is not needed in current system realisation
	 */
	public List<Admin> findAll() {
		return null;
	}
	

	private void addAdmin(Admin admin, ResultSet res) throws SQLException {
		admin.setId(res.getInt(ADMIN_ID));
		admin.setDateAssigned(res.getDate(ADMIN_ASSIGNED));
	}
}
