package com.mk;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeesMapper implements RowMapper<Employees>{
	
	@Override
	public Employees mapRow(ResultSet resultSet, int rowno) throws SQLException {
		
		Employees emp=new Employees();
		emp.setFirstName(resultSet.getString("first_name"));
		emp.setLastName(resultSet.getString("last_name"));
		return emp;
	}
}

