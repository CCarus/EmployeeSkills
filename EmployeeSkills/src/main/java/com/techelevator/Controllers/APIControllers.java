package com.techelevator.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.Dao.EmployeeDao;
import com.techelevator.Dao.EmployeeSkillsDao;
import com.techelevator.Model.Employee;
import com.techelevator.Model.Skills;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIControllers {

	@Autowired
	private EmployeeDao employeeDAO;
	@Autowired
	private EmployeeSkillsDao employeeSkillsDAO;

	@RequestMapping("/employees")
	public List<Employee> displayAllEmployees() {
		List<Employee> allEmployees = employeeDAO.getAllEmployees();
		return allEmployees;
	}

	@PostMapping("/employees")
	public void addNewEmployee(@RequestBody Employee employee) {
		employeeDAO.createNewEmployee(employee);

	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee displayEmployeeById(@PathVariable UUID employeeID) {
		Employee employee = employeeDAO.getEmployeeById(employeeID);
		return employee;
	}

	
	@PutMapping("/employees/{employeeId}")
	public void updateEmployeeById(UUID employeeID, Employee employee) {
	employeeDAO.updateEmployee(employeeID, employee);
	}
	
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployeeById(UUID employeeID) {
		employeeDAO.deleteEmployee(employeeID);
	}

@GetMapping("/employees​/{employeeID}​/skills​/{skillID}")
public List<Skills> returnEmployeeyBySkillID(@PathVariable UUID employeeID) {
List<Skills> employeeSkills = employeeSkillsDAO.getAllSkillsByEmployeeID(employeeID);
	
	return employeeSkills;
}
}
