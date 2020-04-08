package com.techelevator.Jdbc;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Dao.EmployeeDao;
import com.techelevator.Model.Employee;




@Component
public class JdbcEmployeeDao implements EmployeeDao {
	
	
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<Employee> getAllEmployees(){
    List <Employee> employees = new ArrayList<>();
    String sql = "SELECT * FROM employee ORDER BY last_name";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
	while(results.next()) {
		Employee employee = mapRowToEmployee(results);
		employees.add(employee);
	}
	return employees;
}
    @Override
    public Employee getEmployeeById(UUID employeeID) {
    	Employee employeeById = new Employee();
    	String sql = "SELECT * FROM employee WHERE employee_id = ?";
    	SqlRowSet results =jdbcTemplate.queryForRowSet(sql, employeeID);
    	while (results.next()) {
    		employeeById = mapRowToEmployee(results);
    	}
    	return employeeById;
    }

    
	@Override
	public void createNewEmployee(Employee employee) {
		String sql = "INSERT INTO employee (first_name, last_name,"
				+ "company_email, birth_date ,hire_date, role) VALUES ("
				+ "?,?,?,?,?,?)";
		jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(),
				 employee.getCompanyEmail(), employee.getBirthDate(), employee.getHireDate(),
				employee.getRole());
	}
	
	@Override
	public String deleteEmployee(UUID employeeID) {
		
		String sqlDelete = "DELETE FROM employee WHERE employee_id = ?";
		jdbcTemplate.update(sqlDelete, employeeID);
		return "Employee: " + employeeID + " has been removed.";
	}
	
	@Override
	public void updateEmployee(Employee employee, UUID employeeId) {
		System.out.println("employee id is " + employee.getEmployeeID());
		String updateEmployeeSql = "UPDATE employee SET first_name = ?, last_name = ?, "
				+ "company_email = ?, birth_date = ?,hire_date = ?, role =? WHERE employee_id = ?"; 
		jdbcTemplate.update(updateEmployeeSql, employee.getFirstName(), employee.getLastName(),
		employee.getCompanyEmail(), employee.getBirthDate(), employee.getHireDate(), employee.getRole(), employeeId);
	}
	
//how to set all the attributes of the employee from JDBC results
	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setEmployeeID((UUID) result.getObject("employee_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setCompanyEmail(result.getString("company_email"));
		employee.setBirthDate(result.getString("birth_date"));
		employee.setHireDate(result.getString("hire_date"));
		employee.setRole(result.getString("role"));
				
	return employee;
}

}
	

