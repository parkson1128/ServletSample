package db;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DataServlet extends HttpServlet {
   
    private ServletConfig config;
  //Setting JSP page
  String page="DataPage.jsp";

  public void init(ServletConfig config)
    throws ServletException{
     this.config=config;
     }
  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException,IOException {

    PrintWriter out = response.getWriter();
    //Establish connection to MySQL database
    String connectionURL = "jdbc:db2://192.168.114.128:50000/CSHIBANK";
    Connection connection = null;
    ResultSet rs;
    response.setContentType("text/html");
    List dataList = new ArrayList();
      try {
       // Load the database driver

      Class.forName("com.mysql.jdbc.Driver");
      // Get a Connection to the database
      connection = DriverManager.getConnection(connectionURL, "administrator", "25082201");
      //Select the data from the database
      String sql = "select MEMBER_ID from CS_MEMBER";
      Statement s = connection.createStatement();
      s.executeQuery (sql);
      rs = s.getResultSet();

      while (rs.next ()){
        //Add records into data list
        dataList.add(rs.getString("MEMBER_ID"));
//        dataList.add(rs.getString("comname"));
      }
      rs.close ();
      s.close ();
      }catch(Exception e){
      System.out.println("Exception is ;"+e);
      }
      request.setAttribute("data",dataList);
      //Disptching request
      RequestDispatcher dispatcher = request.getRequestDispatcher(page);
      if (dispatcher != null){
        dispatcher.forward(request, response);
      }
  }
}
