package com.techelevator.Model;

import java.util.UUID;

public class Skills{

	private UUID skillID;
	private UUID fieldID;
	private int experience;
	private String summary;
	
	
	public Skills() {
	
	}
	
	public UUID getSkillID() {
		return skillID;
	}
	public void setSkillID(UUID skillID) {
		this.skillID = skillID;
	}
	public UUID getFieldID() {
		return fieldID;
	}
	public void setFieldID(UUID fieldID) {
		this.fieldID = fieldID;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}


	
	
}
