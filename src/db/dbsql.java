package db;


import java.sql.*;


public class dbsql {
	private String username;
    private String password;
    private String connectionURL;
    
 
    dbsql(String username, String password, String connectionURL) {
        this.username = username;
        this.password = password;
        this.connectionURL = connectionURL;
    }
    
     void select(String dbselect) {
        if(dbselect != null) {
                         
        	 
             try {
            	 String test02 ="MEMBER_ID= \n";
				// System.out.println("HelloWorld開始執行資料庫"); 
				 Class.forName("com.ibm.db2.jcc.DB2Driver");
				 Connection con = DriverManager.getConnection (this.connectionURL,this.username,this.password);
				 
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(dbselect);
				 
				 while (rs.next()){
					 	test02 += rs.getString("MEMBER_ID");
				        System.out.println("MEMBER_ID= " + rs.getString("MEMBER_ID") );
				 		
				        test02 +="\n"; 
				        
				 }
				 
				 stmt.close();
				 rs.close();
				 System.out.println("資料庫執行完成");
				 System.out.println(test02); 


				 }catch (Exception e) {
					// TODO: handle exception
					 System.out.println("dbsql exception is= "+ e); 
				 }
             
             
             throw new IllegalArgumentException("dbselect 有例外狀況");
             
        }
        //this.balance += amount;
    }

}
