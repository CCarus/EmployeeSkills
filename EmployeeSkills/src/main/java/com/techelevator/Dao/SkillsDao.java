package com.techelevator.Dao;

import java.util.List;
import java.util.UUID;

import com.techelevator.Model.Employee;
import com.techelevator.Model.Skills;


public interface SkillsDao {
	public List <Skills> getAllSkillsByEmployeeID(UUID employeeID);

	void removeSkillFromEmployeeID(UUID employeeID, UUID skillID);

	void createNewEmployeeSkills(Skills Skills, Employee employee);


	
}

