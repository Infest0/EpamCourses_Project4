package enteties;

import java.util.Date;

/**
 * Encapsulates a patient history note
 * @author Nick
 *
 */
public class PatientHistoryNote {
	
	/**
	 * Id of note in database
	 */
	private int id;
	
	/**
	 * Date of creation of history note
	 */
	private Date date;
	
	/**
	 * Theme of history note
	 */
	private String theme;
	
	/**
	 * Text of history note
	 */
	private String text;
	
	/**
	 * Id of history of patient which current note refers to
	 */
	private int historyId;

	public PatientHistoryNote() {
		super();
	}

	public PatientHistoryNote(int id, Date date, String theme, String text, int historyId) {
		this.id = id;
		this.date = date;
		this.theme = theme;
		this.text = text;
		this.historyId = historyId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
}
