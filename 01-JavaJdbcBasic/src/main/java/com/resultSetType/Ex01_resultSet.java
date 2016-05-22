package com.resultSetType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01_resultSet {

	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		// 1. Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
		
		// 2. Create a statement
		myStmt = myConn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

		
		// 3. Execute SQL query
		myRs = myStmt.executeQuery("select * from employees");

		myRs.absolute(0);
		myRs.next();
		System.out.println(myRs.getString("last_name") + ", "+ myRs.getString("first_name"));
		
		myRs.absolute(3);
		myRs.next();
		System.out.println(myRs.getString("last_name") + ", "+ myRs.getString("first_name"));

		// 4. Process the result set
		while (myRs.next()) {
			System.out.println(myRs.getString("last_name") + ", "+ myRs.getString("first_name"));
		}

	
		
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}

	}
}
