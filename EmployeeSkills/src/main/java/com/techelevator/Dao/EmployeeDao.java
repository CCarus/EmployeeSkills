package com.techelevator.Dao;

import java.util.List;
import java.util.UUID;

import com.techelevator.Model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	
	void createNewEmployee(Employee employee);
	
	String deleteEmployee(UUID employeeID);

	Employee getEmployeeById(UUID employeeID);

	void updateEmployee(UUID employeeID, Employee employee);

	
	
}
