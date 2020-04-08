package com.techelevator.EmployeeSkills;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import cucumber.api.java.After;

public abstract class DAOIntegrationTest {

	
	private static SingleConnectionDataSource dataSource;

	//CRUD
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/EmployeeSKills");
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
}
