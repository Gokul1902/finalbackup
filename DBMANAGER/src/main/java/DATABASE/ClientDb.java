package DATABASE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet("/clientdb")
public class ClientDb extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
       String database ="";
       String ip = (String)sess.getAttribute("ip");
       String name = (String)sess.getAttribute("username");
       String password = (String)sess.getAttribute("password");

		 
       try {
    	   
    	   Class.forName("com.mysql.cj.jdbc.Driver");
         	Connection con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/user", name, password);
         	Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select name from userdetail;");
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnsNumber = rsmd.getColumnCount();
          
          JSONObject userlist = new JSONObject();
          int count=0;
          while (rs.next()) {
        	  count+=1;
                  for (int i = 1; i <= columnsNumber; i++) {

                          String columnValue = rs.getString(i);
                          userlist.put("user"+count,columnValue);
                          
                     }
          
   
       }
          PrintWriter printWriter = response.getWriter();
          printWriter.println(userlist);
          
       }
         
          
		
	 catch (Exception e) {
		// TODO: handle exception
		System.out.println("error2");
	}
	}

}
