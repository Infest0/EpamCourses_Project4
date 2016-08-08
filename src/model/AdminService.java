package model;

import dao.DaoFactory;
import enteties.Admin;

public class AdminService {
	public Admin find(int id) {
		return DaoFactory.getFactory().createAdminDao().find(id);
	}
}
