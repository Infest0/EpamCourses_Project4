package model;

import enteties.Role;
import enteties.RoleFunctions;

/**
 * Grants the interface methods to role DAO in db
 * @author Nick
 *
 */
public class RoleService {
	
	/**
	 * Checks the id, finds it in the corresponding role tables in database
	 *  and returns available roles in system 
	 * @param id - person id
	 */
	public Role defineRoles(int id) {
		Role role = new Role();
		
		if (new PatientService().find(id) != null) {
			role.addRoles(RoleFunctions.PATIENT);
		}
		
		if (new MedicService().find(id) != null) {
			role.addRoles(RoleFunctions.MEDIC);
		}
		
		if (new AdminService().find(id) != null) {
			role.addRoles(RoleFunctions.ADMIN);
		}
		
		return role;
	}
}
