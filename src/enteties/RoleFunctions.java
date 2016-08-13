package enteties;

/**
 * Contains available system roles
 * @author Nick
 *
 */
public enum RoleFunctions {
	 PATIENT(new AvailableFunctions[] {
			AvailableFunctions.SHOW_INFO_ABOUT_ME,
			AvailableFunctions.SHOW_PATIENT_HISTORY }), 
	 MEDIC(  new AvailableFunctions[] { 
	 		AvailableFunctions.SHOW_INFO_ABOUT_ME,
			AvailableFunctions.SHOW_USER_HISTORIES, 
			AvailableFunctions.EXECUTE_APPOINTMENT }),
	ADMIN (  new AvailableFunctions[] { 
			AvailableFunctions.SHOW_INFO_ABOUT_ME,
			AvailableFunctions.SHOW_NOT_DISCHANGED_HISTORIES,
			AvailableFunctions.ADD_PATIENT_HISTORY});

	private RoleFunctions(AvailableFunctions[] roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	 AvailableFunctions[] roleFunctions;

	public AvailableFunctions[] getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(AvailableFunctions[] roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
}
