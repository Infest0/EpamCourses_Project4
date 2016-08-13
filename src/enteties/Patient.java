package enteties;

import java.util.List;

/**
 * Encapsulates a patient
 * @author Nick
 *
 */
public class Patient extends Person {
	
	/**
	 * Current patient history
	 */
	private List<PatientHistory> patientHistories;
	
	public Patient() {
		super();
	}

	public Patient(List<PatientHistory> patientHistories) {
		super();
		this.patientHistories = patientHistories;
	}

	public List<PatientHistory> getPatientHistories() {
		return patientHistories;
	}

	public void setPatientHistories(List<PatientHistory> patientHistories) {
		this.patientHistories = patientHistories;
	}
}
