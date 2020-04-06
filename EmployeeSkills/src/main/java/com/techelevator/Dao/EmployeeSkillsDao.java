package com.techelevator.Dao;

import java.util.List;
import java.util.UUID;

import com.techelevator.Model.EmployeeSkills;
import com.techelevator.Model.Skills;

public interface EmployeeSkillsDao {

	public List <Skills> getAllSkillsByEmployeeID(UUID employeeID);

	void createNewEmployeeSkills(EmployeeSkills employeeSkills);

	void removeSkillFromEmployeeID(UUID employeeID, UUID skillID);
	
}
