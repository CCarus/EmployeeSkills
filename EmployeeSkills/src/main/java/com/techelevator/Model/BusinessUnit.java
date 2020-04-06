package com.techelevator.Model;

import java.util.UUID;

public class BusinessUnit {

	private UUID businessUnitID;
	private String name;
	private String description;
	private UUID managerID;
	private UUID subordinateID;
	
	public BusinessUnit () {
		
	}

	public UUID getBusinessUnitID() {
		return businessUnitID;
	}

	public void setBusinessUnitID(UUID businessUnitID) {
		this.businessUnitID = businessUnitID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getManagerID() {
		return managerID;
	}

	public void setManagerID(UUID managerID) {
		this.managerID = managerID;
	}

	public UUID getSubordinateID() {
		return subordinateID;
	}

	public void setSubordinateID(UUID subordinateID) {
		this.subordinateID = subordinateID;
	}
	
	
	
}
