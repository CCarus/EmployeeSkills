package com.techelevator.Model;

import java.util.UUID;

public class EmployeeSkills {

	private UUID skillID;
	private UUID employeeID;
	
	
	
	public EmployeeSkills() {
		
	}



	public UUID getSkillID() {
		return skillID;
	}



	public void setSkillID(UUID skillID) {
		this.skillID = skillID;
	}



	public UUID getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(UUID employeeID) {
		this.employeeID = employeeID;
	}
	
	
}
