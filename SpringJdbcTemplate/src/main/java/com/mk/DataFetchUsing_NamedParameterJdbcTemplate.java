package com.mk;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataFetchUsing_NamedParameterJdbcTemplate {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void getData(){
		String sql="select * from employees where id=:empId";
		Map<String,String> namedParameters=new HashMap<String,String>();
		namedParameters.put("empId", "1");   
      
		
		Employees emp= (Employees) namedParameterJdbcTemplate.queryForObject(sql,namedParameters,new EmployeesMapper());
		System.out.println("Customer Details:   Name:"+emp.getFirstName()+" "+ emp.getLastName());
		
	}
}
