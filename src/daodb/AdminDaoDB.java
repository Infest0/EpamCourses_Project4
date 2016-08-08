package daodb;

import static daodb.QueryHandler.*;
import static daodb.DbNameHandler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.AdminDao;
import enteties.Admin;

public class AdminDaoDB implements AdminDao{

	@Override
	public void create(Admin e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Admin e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	private void addAdmin(Admin admin, ResultSet res) throws SQLException {
		admin.setId(res.getInt(ADMIN_ID));
		admin.setDateAssigned(res.getDate(ADMIN_ASSIGNED));
	}
}