package model;

import java.util.List;
import dao.DaoFactory;

/**
 * Grants the interface methods to rule DAO in db
 * @author Nick
 *
 */
public class RuleService {
	 public List<String> getRules(String speciality) {
		return DaoFactory.getFactory().createRulesDaoDB().getConstraints(speciality);
	}
}
