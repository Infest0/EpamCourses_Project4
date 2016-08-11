package enteties;

/**
 * Encapsulates a patient
 * @author Nick
 *
 */
public class Patient extends Person {
	
	/**
	 * Current patient history
	 */
	private PatientHistory patientHistory;
	
	public Patient() {
		super();
	}

	public Patient(String fname, String sname, String address, int id, PatientHistory patientHistory) {
		super(fname, sname, address, id);
		this.patientHistory = patientHistory;
	}

	public PatientHistory getPatientHistory() {
		return patientHistory;
	}
}
