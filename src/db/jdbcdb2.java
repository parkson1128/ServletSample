package db;
import java.sql.*;


public class jdbcdb2 {
 
public static void main( String args[]) {
 

	String connectionURL="jdbc:db2://192.168.114.128:50000/CSHIBANK";
	String username="administrator";
	String password="25082201";

// Change the connection string according to your db, ip, username and password	
	
try {
	System.out.println("開始執行資料庫"); 
    // Load the Driver class.
    Class.forName("com.ibm.db2.jcc.DB2Driver");
    // If you are using any other database then load the right driver here.
 
    //Create the connection using the static getConnection method
    Connection con = DriverManager.getConnection (connectionURL,username,password);
//    Connection con = DriverManager.getConnection ( 
//  	      "jdbc:db2://192.168.114.128:50000/CSHIBANK", 
//  	      "administrator","25082201");
    //Create a Statement class to execute the SQL statement
//    System.out.println("開始執行createStatement");
    Statement stmt = con.createStatement();
 
    //Execute the SQL statement and get the results in a Resultset
    //System.out.println("開始執行executeQuery");
    ResultSet rs = stmt.executeQuery("Select MEMBER_ID from CS_MEMBER");
 
    // Iterate through the ResultSet, displaying two values
    // for each row using the getString method
   // System.out.println("開始執行 while");
    while (rs.next())
        System.out.println("MEMBER_ID= " + rs.getString("MEMBER_ID") );

    System.out.println("資料庫執行完成"); 
}
catch (SQLException e) {
    e.printStackTrace();
}
catch (Exception e) {
    e.printStackTrace();
}
finally {
    // Close the connection
//    con.close();
	}
}// end main
}