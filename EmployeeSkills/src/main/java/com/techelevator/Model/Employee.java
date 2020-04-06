package com.techelevator.Model;



import java.util.UUID;



public class Employee {
	
	private UUID employeeID;
	private String firstName;
	private String lastName;
	private String companyEmail;
	private String birthDate;
	private String hireDate;
	private String role;

	
	
	public Employee() {
	
	}
	
	public Employee(UUID employeeID, String firstName, String lastName,
					String companyEmail, String birthDate, String hireDate, String role) {
		this.employeeID= employeeID;
		this.firstName= firstName;
		this.lastName= lastName;
		this.companyEmail = companyEmail;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.role = role;
	
	}
	
	
	public UUID getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(UUID employeeID) {
		this.employeeID = UUID.randomUUID();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
