package com.techelevator.EmployeeSkills;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Jdbc.JdbcEmployeeDao;
import com.techelevator.Model.Employee;

import cucumber.api.java.After;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
private static SingleConnectionDataSource dataSource;
	private JdbcEmployeeDao employeeDao;
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	public EmployeeDaoTest() {
		employeeDao = new JdbcEmployeeDao(dataSource);
		
	}
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/employeeSkills");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
	
		dataSource.setAutoCommit(false);
	}


	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}


	public DataSource getDataSource() {
		return dataSource;
	}
	
	

@Test
public void test_return_all_employees() {

	List <Employee> allEmployees = employeeDao.getAllEmployees();
	int countEmployees = allEmployees.size();

	Employee employee = new Employee("Michelin", "Man", "michelin.man@gmail.com", "1970-01-01", "1995-01-01", "Director");
	employeeDao.createNewEmployee(employee);


	String sqlCount = "SELECT * FROM employee";
	List <Employee> allEmployeesUpdated = employeeDao.getAllEmployees();
	int countAfterAdded = allEmployeesUpdated.size();

	assertEquals(countEmployees + 1 , countAfterAdded);
	}


//	@Test
	//public void test_get_employee_by_id() {
		//Employee employee = employeeDao.getEmployeeById();
	//}
	
}




	
