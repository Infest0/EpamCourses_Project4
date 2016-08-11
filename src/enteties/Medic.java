package enteties;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates a medic entity in hospital system
 * @author Nick
 *
 */
public class Medic extends Person {
	
	/**
	 * String representation of medic speciality
	 */
	private String speciality;
	
	/**
	 * List of assigned to medic patient histories 
	 */
	private List<PatientHistory> patientHistories;
	
	public Medic() {
		super();
	}

	public Medic(String fname, String sname, String address, int id, String speciality) {
		super(fname, sname, address, id);
		patientHistories = new ArrayList<>();
		this.speciality = speciality;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<PatientHistory> getPatientHistories() {
		return patientHistories;
	}

	public void setPatientHistories(List<PatientHistory> patientHistories) {
		this.patientHistories = patientHistories;
	}	
}
