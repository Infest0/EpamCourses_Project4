package enteties;

import java.sql.Date;
import java.util.List;

/**
 * Encapsulates a patient history
 * @author Nick
 *
 */
public class PatientHistory {
	
	/**
	 * Id of patient history id database
	 */
	private int id;
	
	/**
	 * Date, when patient history was added by admin
	 */
	private Date dateAdded;
	
	/**
	 * Date, when patient history was discharged
	 */
	private Date dateDischarged;
	
	/**
	 * List of medics that were directed to current history
	 */
	private List<Medic> assignedMedics;
	
	/**
	 * List of history notes that refer to current patient history
	 */
	private List<PatientHistoryNote> patientHistoryNotes;
	
	/**
	 *  List of procedures that refer to current patient history
	 */
	private List<Procedure> assignedProcedures;
	
	/**
	 * Initial complaints of patients
	 */
	private String complaints;
	
	/**
	 * Object of patient which refers to current history
	 */
	private Patient patient;
	
	/**
	 * Id of patient which refers to current history
	 */
	private int patientId;

	public PatientHistory() {
		super();
	}

	public PatientHistory(int id, Date dateAdded, Date dateDischanged, List<Medic> assignedMedics,
			List<PatientHistoryNote> patientHistoryNotes, List<Procedure> assignedProcedures, String complaints,
			Patient patient, int patientId) {
		this.id = id;
		this.dateAdded = dateAdded;
		this.dateDischarged = dateDischanged;
		this.assignedMedics = assignedMedics;
		this.patientHistoryNotes = patientHistoryNotes;
		this.assignedProcedures = assignedProcedures;
		this.complaints = complaints;
		this.patient = patient;
		this.patientId = patientId;
	}

	public List<PatientHistoryNote> getPatientHistory() {
		return patientHistoryNotes;
	}

	public List<Procedure> getAssignedProcedures() {
		return assignedProcedures;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateDischanged() {
		return dateDischarged;
	}

	public void setDateDischanged(Date dateDischanged) {
		this.dateDischarged = dateDischanged;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPatientHistory(List<PatientHistoryNote> patientHistory) {
		this.patientHistoryNotes = patientHistory;
	}

	public void setAssignedProcedures(List<Procedure> assignedProcedures) {
		this.assignedProcedures = assignedProcedures;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<PatientHistoryNote> getPatientHistoryNotes() {
		return patientHistoryNotes;
	}

	public void setPatientHistoryNotes(List<PatientHistoryNote> patientHistoryNotes) {
		this.patientHistoryNotes = patientHistoryNotes;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public List<Medic> getAssignedMedics() {
		return assignedMedics;
	}

	public void setAssignedMedics(List<Medic> assignedMedics) {
		this.assignedMedics = assignedMedics;
	}
}
