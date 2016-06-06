package com.mk;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

class MyBatchPreparedStatementSetter implements BatchPreparedStatementSetter {

	@Override
	public int getBatchSize() {
		return 5;
	}

	@Override
	public void setValues(PreparedStatement ps, int count) throws SQLException {
		ps.setLong(1, count);
		ps.setString(2, "Mohit");
	}
}

@Component
public class BatchUpdate {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSourceTransactionManager dataSourceTransactionManager;

	
//********* 	Transaction  approach  1 ***********************************************************	
	void update() {
		DefaultTransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus dbTransactionStatus=null;
		try{
			dbTransactionStatus=dataSourceTransactionManager.getTransaction(def);
			String sql = "INSERT INTO simpleentityexample (ID, username) VALUES (?, ?)";
	
			int result[] = jdbcTemplate.batchUpdate(sql, new MyBatchPreparedStatementSetter());
			for (int i = 0; i < result.length; i++) {
				System.out.println("Result : (" + i + ") = " + result[i]);
			}
			dataSourceTransactionManager.commit(dbTransactionStatus);
		}catch(Exception e){
			System.out.println("Exception : "+ e.getMessage());
			dataSourceTransactionManager.rollback(dbTransactionStatus);
		}
	}
	
//********* 	Transaction  approach  2  **************************************************************
	
	@Transactional
	public void transactionalUpdate() {
		for (int count = 0; count < 5; count++) {
			String sql = "INSERT INTO simpleentityexample (ID, username) VALUES (?, ?)";
			jdbcTemplate.update(sql, count, "Mohit");
		}
	};
}
