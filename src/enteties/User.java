package enteties;

/**
 * Class that encapsulates user in database
 * @author Nick
 */
public class User {
	private int id;
	private int password;
	private String username;
	private String salt;

	public User() {
	}

	public User(int id, int password, String username, String salt) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.salt = salt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
