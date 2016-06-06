package com.mk;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class StoredProcedure {
	@Autowired
	private DataSource dataSource;
	
/*
 CREATE DEFINER=`student`@`localhost` PROCEDURE `increase_salaries_for_department`(IN the_department VARCHAR(64), IN increase_amount DECIMAL(10,2))
BEGIN
	UPDATE employees SET salary= salary + increase_amount where department=the_department;
END
*/
	
	public void increaseSalaries_IN(){
		String theDepartment = "Engineering";
		double  increase_amount = 122;
	
		SqlParameterSource in = new MapSqlParameterSource().addValue("the_department", theDepartment).addValue("increase_amount",increase_amount);
		SimpleJdbcCall jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("increase_salaries_for_department");
		jdbcCall.execute(in);
	}

/*
CREATE DEFINER=`student`@`localhost` PROCEDURE `greet_the_department`(INOUT department VARCHAR(64))
BEGIN
	SET department = concat('Hello to the awesome ', department, ' team!');
END
*/	
	public void greetDepartment_INOUT(){
		String theDepartment = "Engineering";
			
		SqlParameterSource in = new MapSqlParameterSource().addValue("department", theDepartment);

		SimpleJdbcCall jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("greet_the_department");
		Map<String, Object> out=jdbcCall.execute(in);
		
		for (Map.Entry<String, Object> entry : out.entrySet())
		{
		    System.out.println("Call Out Key:" + entry.getKey() + ",  Value:" + entry.getValue());
		}
	}


/*
CREATE DEFINER=`student`@`localhost` PROCEDURE `get_count_for_department`(IN the_department VARCHAR(64), OUT the_count INT)
BEGIN
	SELECT COUNT(*) INTO the_count FROM employees where department=the_department;
END 	
 */
	public void getCountForDepartment_INandOUT(){
		String theDepartment = "Engineering";
		int count=0;	
		SqlParameterSource in = new MapSqlParameterSource().addValue("the_department", theDepartment).addValue("the_count", count);

		SimpleJdbcCall jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("get_count_for_department");
		Map<String, Object> out=jdbcCall.execute(in);
		
		for (Map.Entry<String, Object> entry : out.entrySet())
		{
		    System.out.println("Call Out Key:" + entry.getKey() + ",  Value:" + entry.getValue());
		}
		
		System.out.println("Count :" +count );
	}

/*
CREATE DEFINER=`student`@`localhost` PROCEDURE `get_employees_for_department`(IN the_department VARCHAR(64))
BEGIN
	SELECT * from employees where department=the_department;
END	
 */
	public void getEmployeesForDepartment_IN_ListOut(){
		String theDepartment = "Engineering";
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("the_department", theDepartment);

		SimpleJdbcCall jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("get_employees_for_department");
		Map<String, Object> out=jdbcCall.execute(in);
		
		for (Map.Entry<String, Object> entry : out.entrySet())
		{
		    System.out.println("Call Out Key:" + entry.getKey() + ",  Value:" + entry.getValue());
		}
	}
}
