package DATABASE;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
@WebServlet ("/DB")
public class Database extends HttpServlet{
	  public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession sess = req.getSession();
       String database ="";
       String ip = (String)sess.getAttribute("ip");
       String name = (String)sess.getAttribute("username");
       String password = (String)sess.getAttribute("password");

		 
       try {
    	   
    	   Class.forName("com.mysql.cj.jdbc.Driver");
         	Connection con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/" + database, name, password);
         	Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("show databases;");
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnsNumber = rsmd.getColumnCount();
          int count=0;
          JSONObject databaselist = new JSONObject();
          while (rs.next()) {
        	  count+=1;
                  for (int i = 1; i <= columnsNumber; i++) {

                          String columnValue = rs.getString(i);
                          databaselist.put("Data"+count,columnValue);
                          
                     }
          
   
       }
          PrintWriter printWriter = res.getWriter();
          printWriter.println(databaselist);
                  

          
//          RequestDispatcher rd = 
//                  req.getRequestDispatcher("/show.jsp");
//          rd.forward(req,res);
          
       }
         
          
		
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
		System.out.println("error2");
	}
	  }
       }
	  
       


