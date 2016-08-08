package enteties;

import java.util.HashSet;
import java.util.Set;

/**
 * Encapsulates user possible actions
 * @author Nick
 *
 */
public class Role {
	Set<AvailableFunctions> availableFunctions;

	public Role() {
		availableFunctions = new HashSet<>();
	}

	public Set<AvailableFunctions> getAvailableFunctions() {
		return availableFunctions;
	}

	public void setAvailableFunctions(Set<AvailableFunctions> availableFunctions) {
		this.availableFunctions = availableFunctions;
	} 
	
	public void addRole(AvailableFunctions function) {
		availableFunctions.add(function);
	}
	
	public void addRoles(RoleFunctions roleFunctions) {
		for (AvailableFunctions availableFunction : roleFunctions.getRoleFunctions()) {
			this.addRole(availableFunction);
		}
	}
	
	public boolean contains(String functionName) {
		return availableFunctions.contains(AvailableFunctions.valueOf(functionName));
	}
}
