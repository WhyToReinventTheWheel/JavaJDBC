package com.mk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataFetchUsing_JdbcTemplate {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void getData(){
	
		List<Employees> list=(List<Employees>) jdbcTemplate.query("select * from employees",new EmployeesMapper());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Customer No: " +i+ " Name:"+list.get(i).getFirstName()+" "+ list.get(i).getLastName());
		}
	}
}
