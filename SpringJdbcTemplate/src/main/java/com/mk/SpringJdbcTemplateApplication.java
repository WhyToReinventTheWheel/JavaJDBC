package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcTemplateApplication.class, args);
//JdbcTemplate		
/*
		System.out.println("<--------------------------Using DataFetchUsing_JdbcTemplate---------------------------------------->");
		DataFetchUsing_JdbcTemplate jdbcTemplate=context.getBean(DataFetchUsing_JdbcTemplate.class);
		jdbcTemplate.getData();
*/		

		
//NamedParameterJdbcTemplate		
/*		
		System.out.println("<---------------*******-----------Using DataFetchUsing_NamedParameterJdbcTemplate------------------*****---------------------->");
		DataFetchUsing_NamedParameterJdbcTemplate namedParameterJdbcTemplate=context.getBean(DataFetchUsing_NamedParameterJdbcTemplate.class);
		namedParameterJdbcTemplate.getData();
*/
	

//BatchUpdate			
/*		
		System.out.println("<--------------$$$$ -------BatchUpdate----------------- $$$$$---------------------->");
		BatchUpdate batchUpdate=context.getBean(BatchUpdate.class);
		batchUpdate.update();
		batchUpdate.transactionalUpdate();
*/

//StoredProcedure				
/*		
		System.out.println("<--------------$$$$ --------------StoredProcedure---------- $$$$$---------------------->");
		StoredProcedure storedProcedure=context.getBean(StoredProcedure.class);
		//storedProcedure.callStoredProccess();
		//storedProcedure.greetDepartment_INOUT();
		//storedProcedure.getCountForDepartment_INandOUT();
		storedProcedure.getEmployeesForDepartment_IN_ListOut();
*/
		
	}
}


