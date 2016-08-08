package enteties;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates a medic
 * @author Nick
 *
 */
public class Medic extends Person {
	private String speciality;
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
