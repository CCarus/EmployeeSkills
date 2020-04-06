package com.techelevator.Jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Dao.EmployeeSkillsDao;
import com.techelevator.Model.EmployeeSkills;
import com.techelevator.Model.Skills;

@Component
public class JdbcEmployeeSkillsDao implements EmployeeSkillsDao{

	private final JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    public JdbcEmployeeSkillsDao(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
		@Override
		public List <Skills> getAllSkillsByEmployeeID(UUID employeeID) {
			List <Skills> employeeSkills = new ArrayList<>();
			String sql = "SELECT skill_id FROM employee_skills WHERE employee_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, employeeID);
			 while(results.next()) {
				 Skills skill = new Skills();
				 skill.setSkillID((UUID)results.getObject("skill_id"));
				 skill.setFieldID((UUID)results.getObject("field_id"));
				 skill.setExperience(results.getInt("experience"));
				 skill.setSummary(results.getString("summary"));
				 employeeSkills.add(skill);
				}
				return employeeSkills;	
			}
		
		@Override
		public void createNewEmployeeSkills(EmployeeSkills employeeSkills) {
			String sql = "INSERT INTO employee_skills (skill_id, employee_id) VALUES ("
					+ "?, ?)";
			jdbcTemplate.update(sql, employeeSkills.getSkillID(), employeeSkills.getEmployeeID());
		}
		
		public void removeSkillFromEmployeeID(UUID employeeID, UUID skillID) {
			String sqlRemoveSkill = "DELETE skill_id FROM employee_skills WHERE  skill_id=? AND employee_id =?";
			jdbcTemplate.update(sqlRemoveSkill, employeeID, skillID);
		}
		
		
}
	
		
