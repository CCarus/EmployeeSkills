package com.techelevator.Model;

import java.util.UUID;

public class Field {
	
	private UUID fieldID;
	private String fieldName;
	private String typeOfTechnicalField;
	
	public Field() {
		
	}

	public UUID getFieldID() {
		return fieldID;
	}

	public void setFieldID(UUID fieldID) {
		this.fieldID = fieldID;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getTypeOfTechnicalField() {
		return typeOfTechnicalField;
	}

	public void setTypeOfTechnicalField(String typeOfTechnicalField) {
		this.typeOfTechnicalField = typeOfTechnicalField;
	}
	
	

}
