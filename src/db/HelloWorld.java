package db;

import java.io.PrintWriter;
//import java.util.Map;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import db.dbsql;

/**
 * Servlet implementation class HelloWorld
 */

@WebServlet(
		urlPatterns = { "/HelloWorld" },
		initParams = { 
				@WebInitParam(name = "default123", value = "this is a default value123")
		}
		)
		
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("123456test-Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("開始執行doPost-servlet"); 
//		String connectionURL="jdbc:db2://192.168.114.128:50000/CSHIBANK";
//		String username="administrator";
//		String password="25082201";
		
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
			// System.out.println("HelloWorld開始執行資料庫"); 
			 
			 String value =  request.getParameter("value");
//			 System.out.println("from servlet print");
			 System.out.println("value from JSP=" + value);
			 System.out.println("\n\n");
			 
			 PrintWriter out = response.getWriter();
			 //System.out.println("HelloWorld開始執行回傳JSP"); 
			 //out.println("from servlet9999");
			 
			 String test02 ="MEMBER_ID= \n";
			 
			 dbsql sql = new dbsql("administrator", "25082201", "jdbc:db2://192.168.114.128:50000/CSHIBANK");
			 sql.select("Select MEMBER_ID from CS_MEMBER");
			 

		      //  System.out.println(acct);
			 
			 
			 
/*			 try {
				 System.out.println("HelloWorld開始執行資料庫"); 
				 Class.forName("com.ibm.db2.jcc.DB2Driver");
				 Connection con = DriverManager.getConnection (connectionURL,username,password);
				 
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery("Select MEMBER_ID from CS_MEMBER");
				 
				 while (rs.next()){
					 	test02 += rs.getString("MEMBER_ID");
				        System.out.println("MEMBER_ID= " + rs.getString("MEMBER_ID") );
				 		
				        test02 +="\n"; 
				        
				 }
				 System.out.println("資料庫執行完成"); 
				 stmt.close();
				 rs.close();
				 
				 out.println(test02);
				 System.out.println("HelloWorld回傳JSP_執行完畢");
			 }catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Exception is= "+ e); 
		 	 }// end catch
			 
*/				 
			
		 
		
/*		String value =  request.getParameter("value");
		//request.getParameterMap();
		//int value = 111;
		//System.out.println("from servlet");
		//System.out.println("value from JSP=" + value);
		Map<String, String[]> parames = request.getParameterMap();
		for(String key :parames.keySet()){
			System.out.println("key="+key+","+parames.get(key)[0]);
		}
		PrintWriter out = response.getWriter();
		out.println("from servlet9999");
		
*/
	
	}
	

	

}
