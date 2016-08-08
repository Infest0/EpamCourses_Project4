package enteties;

import java.util.Date;

/**
 * Encapsulates a patient history note
 * @author Nick
 *
 */
public class PatientHistoryNote {
	private int id;
	private Date date;
	private String theme;
	private String text;
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
