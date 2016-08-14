package model;

import dao.DaoFactory;
import enteties.Admin;

public class AdminService {
	
	/**
	 * returns admin id by its id in database
	 * @param id admin id in database
	 */
	public Admin find(int id) {
		return DaoFactory.getFactory().createAdminDao().find(id);
	}
}
