package enteties;

import java.sql.Date;

/**
 * Class that encapsulates system administrator entity in hospital system
 * @author Nick
 *
 */
public class Admin extends Person {
	
	/**
	 * The date when person get the administrator rights
	 */
	private Date dateAssigned;
	
	public Admin() { }

	public Admin(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
	
	public Admin(String fname, String sname, String address, int id, Date dateAssigned) {
		super(fname, sname, address, id);
		this.dateAssigned = dateAssigned;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
}
