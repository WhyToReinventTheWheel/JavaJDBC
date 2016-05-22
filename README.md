
* http://dev.mysql.com/downloads/
* http://dev.mysql.com/downloads/connector/j/


 <dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>6.0.2</version>
 </dependency>

----------------
### Steps
----------------
#### STEP 1: Register JDBC driver
	- try {
	-	Class.forName("oracle.jdbc.driver.OracleDriver");
	- }
	- catch(ClassNotFoundException ex) {}
	
* Note : 	All next Steps will throw java.sql.SQLException:
*#### STEP 2: Open a connection
	* RDBMS		JDBC driver name			URL format
	* MySQL		com.mysql.jdbc.Driver			jdbc:mysql://hostname/ databaseName
	* ORACLE	oracle.jdbc.driver.OracleDriver		jdbc:oracle:thin:@hostname:port Number:databaseName
	* DB2		COM.ibm.db2.jdbc.net.DB2Driver		jdbc:db2:hostname:port Number/databaseName
	* Sybase	com.sybase.jdbc.SybDriver		dbc:sybase:Tds:hostname: port Number/databaseName

	- Approach I
		- Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","userName","passwd"););
	- Approach II
		- Connection conn = DriverManager.getConnection("jdbc:oracle:thin:username/password@amrood:1521:EMP");

*#### STEP 3: Create Statement
	- Statement stmt = conn.createStatement();

*#### STEP 4: Execute a query
	- ResultSet rs = stmt.executeQuery(sql);

*#### STEP 5: Extract data from result set	
	- while(rs.next()){
        - 	//Retrieve by column name
        - 	int id  = rs.getInt("id");
        - 	String first = rs.getString("first");
        - 	String last = rs.getString("last");
	- }
	  
