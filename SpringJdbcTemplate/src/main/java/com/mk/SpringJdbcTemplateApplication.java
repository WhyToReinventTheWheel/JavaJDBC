package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcTemplateApplication.class, args);
		
		System.out.println("<--------------------------Using DataFetchUsing_JdbcTemplate---------------------------------------->");
		DataFetchUsing_JdbcTemplate jdbcTemplate=context.getBean(DataFetchUsing_JdbcTemplate.class);
		jdbcTemplate.getData();
		
		System.out.println("<---------------*******-----------Using DataFetchUsing_NamedParameterJdbcTemplate------------------*****---------------------->");
		DataFetchUsing_NamedParameterJdbcTemplate namedParameterJdbcTemplate=context.getBean(DataFetchUsing_NamedParameterJdbcTemplate.class);
		namedParameterJdbcTemplate.getData();
	}
}


