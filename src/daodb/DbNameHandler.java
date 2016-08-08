package daodb;

public interface DbNameHandler {
	/**
	 * JNDI driver name
	 */
	String JNDI_NAME = "jdbc/HospitalJNDI";
	
	/**
	 * Database name
	 */
	String DB_NAME = "hospital";
	
	/**
	 * Admin table
	 * admin_id - INT(11)
	 * date_assigned - DATE
	 */
	String ADMIN_TABLE = "admins";
	String ADMIN_ID = "admin_id";
	String ADMIN_ASSIGNED = "date_assigned";
	
	/**
	 * Stores a types of medic in system id - INT(11) name - VARCHAR(45)
	 */
	String MEDIC_TYPE_TABLE = "medic_types";
	String MEDIC_ID_TYPE = "id";
	String MEDIC_TYPE_NAME = "name";

	/**
	 * Stores a procedure types in system proc_type_id - INT(11) name -
	 * VARCHAR(45)
	 */
	String PROCEDURE_TYPE_TABLE = "procedure_types";
	String PROCEDURE_TYPE_ID = "proc_type_id";
	String PROCEDURE_TYPE_NAME = "name";

	/**
	 * Stores a rules, which types of medics can do some types of operations id
	 * - INT(11) procedure_id - INT(11) medic_id - INT(11)
	 */
	String RULE_TYPE_TABLE = "procedure_medic";
	String RULE_TYPE_ID = "id";
	String RULE_PROCEDURE_ID = "procedure_id";
	String RULE_MEDIC_ID = "medic_id";

	/**
	 * Stores data about persons person_id - INT(11) first_name - varchar(45)
	 * last_name - varchar(45) address - LONGTEXT
	 **/

	String PERSON_TABLE = "persons";
	String PERSON_ID = "person_id";
	String PERSON_FNAME = "first_name";
	String PERSON_LNAME = "last_name";
	String PERSON_ADDRESS = "address";

	/**
	 * Stores data about medics person_id - INT(11) medic_type - INT(11)
	 */
	String MEDIC_TABLE = "medics";
	String MEDIC_PERSON_ID = "person_id";
	String MEDIC_TYPE_ID = "medic_type";

	/**
	 * Stores data about procedures proc_id - INT(11) proc_type_id - INT(11)
	 * pat_hist_id - INT(11) medic_id - INT(11)
	 */
	String PROCEDURE_TABLE = "procedures";
	String PROCEDURE_ID = "proc_id";
	String PROCEDURE_ID_TYPE = "proc_type_id";
	String PROCEDURE_HISTORY = "pat_hist_id";
	String PROCEDURE_ASSIGNED_MEDIC = "medic_id_assigned";
	String PROCEDURE_EXECUTED_MEDIC = "medic_id_executed";
	String PROCEDURE_DATE_ASSIGNED = "date_assigned";
	String PROCEDURE_DATE_EXECUTED = "date_executed";
	String PROCEDURE_DETAILS = "details";
	
	/**
	 * Stores data about patient histories ph_id - INT(11) id_pat_hist - INT(11)
	 * complaints - LONGTEXT date_added - DATE date_dischanged - DATE medic_id -
	 * INT(11)
	 */
	String PATIENT_HISTORY_TABLE = "patient_history";
	String PATIENT_HISTORY_ID = "ph_id";
	String PATIENT_HISTORY_PAT_ID = "id_pat_hist";
	String PATIENT_HISTORY_COMPLAINTS = "complaints";
	String PATIENT_HISTORY_DATE_ADDED = "date_added";
	String PATIENT_HISTORY_DATE_DISCHANGED = "date_dischanged";

	/**
	 * Stores all history notes id - INT(11) theme - VARCHAR(45) date - DATE
	 * text - MEDIUMTEXT pat_hist_id - INT(11)
	 */
	 String HISTORY_NOTES_TABLE = "history_note";
	String HISTORY_NOTES_ID = "id";
	String HISTORY_NOTES_THEME = "theme";
	String HISTORY_NOTES_DATE = "date";
	String HISTORY_NOTES_TEXT = "text";
	String HISTORY_NOTES_PAT_ID = "pat_hist_id";

	/**
	 * Stores all patients id - INT(11) person_id - INT(11)
	 */
	String PATIENT_TABLE = "patients";
	String PATIENTS_ID = "id";
	String PATIENTS_PERSON_ID = "person_id";

	/**
	 * Stores logging data person_id - INT(11) username - VARCHAR(60) password -
	 * INT(30) salt - VARCHAR(30)
	 */
	String LOG_TABLE = "logdata";
	String LOG_PERSON_ID = "person_id";
	String LOG_USERNAME = "username";
	String LOG_PASSWORD = "password";
	String LOG_SALT = "salt";

	/**
	 * Stores many-to-many dependency medics with patient history
	 */
	String MEDIC_HISTORIES_TABLE = "medic_histories";
	String MEDIC_HISTORIES_ID = "id";
	String MEDIC_HISTORIES_MEDIC_ID = "medic_id";
	String MEDIC_HISTORIES_HISTORY_ID = "history_id";
}
