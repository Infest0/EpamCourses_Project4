package enteties;

import java.sql.Date;

/**
 * Encapsulates a procedure
 * @author Nick
 *
 */
public class Procedure {
	private int id;
	private String type;
	private Medic assignedMedic;
	private Medic executedMedic;
	private Date dateAssigned;
	private Date dateExecuted;
	private String details;
	private int historyId;
	private int assignedMedicId;
	private int executedMedicId;
	private int procedureTypeId;

	public Procedure() {
	}

	public Procedure(int id, String type, Medic assignedMedic, Medic executedMedic, Date dateAssigned,
			Date dateExecuted, String details, int historyId, int assignedMedicId, int executedMedicId,
			int procedureTypeId) {
		super();
		this.id = id;
		this.type = type;
		this.assignedMedic = assignedMedic;
		this.executedMedic = executedMedic;
		this.dateAssigned = dateAssigned;
		this.dateExecuted = dateExecuted;
		this.details = details;
		this.historyId = historyId;
		this.assignedMedicId = assignedMedicId;
		this.executedMedicId = executedMedicId;
		this.procedureTypeId = procedureTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Medic getAssignedMedic() {
		return assignedMedic;
	}

	public void setAssignedMedic(Medic assignedMedic) {
		this.assignedMedic = assignedMedic;
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

	public Medic getExecutedMedic() {
		return executedMedic;
	}

	public void setExecutedMedic(Medic executedMedic) {
		this.executedMedic = executedMedic;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public Date getDateExecuted() {
		return dateExecuted;
	}

	public void setDateExecuted(Date dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public int getAssignedMedicId() {
		return assignedMedicId;
	}

	public void setAssignedMedicId(int assignedMedicId) {
		this.assignedMedicId = assignedMedicId;
	}

	public int getExecutedMedicId() {
		return executedMedicId;
	}

	public void setExecutedMedicId(int executedMedicId) {
		this.executedMedicId = executedMedicId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getProcedureTypeId() {
		return procedureTypeId;
	}

	public void setProcedureTypeId(int procedureTypeId) {
		this.procedureTypeId = procedureTypeId;
	}
}
