package enteties;

/**
 * Class that encapsulates a real person
 * @author Infest0
 */
public class Person {
	private int id;
	private String fname;
	private String sname;
	private String address;
	
	public Person() {
	}

	public Person(String fname, String sname, String address, int id) {
		this.fname = fname;
		this.sname = sname;
		this.address = address;
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
