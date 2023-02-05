package DATABASE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DbUpdate
 */
@WebServlet("/DbUpdate")
public class DbUpdate extends HttpServlet {
	public boolean universalChange(Connection localcon, Connection remotecon, boolean check,String queryinput) {
		boolean result;
		try {
			Statement localst = localcon.createStatement();
			Statement remotest = remotecon.createStatement();
			String sql = queryinput;
			if(check==true) {
				localst.executeUpdate(sql);
				check=false;
			}
			remotest.executeUpdate(sql);
			result = true;
			return result;
		}
		catch(Exception e){
			result = false;
			System.out.println("i am main error");
			return result;
		}
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String MasterIp = (String)sess.getAttribute("MasterIp");
		String MasterUser =(String)sess.getAttribute("MasterUser");
		String MasterPass = (String)sess.getAttribute("MasterPass");
		System.out.println("ok"+MasterIp);
		System.out.println("ok"+MasterUser);
		System.out.println("ok"+MasterPass);
		PrintWriter out = response.getWriter();
		String query = request.getParameter("clientquery");
		if(query!="") {
		String database = (String)sess.getAttribute("database");
		sess.setAttribute("databases", database);
		request.setAttribute("userquery", query);
		}else {
			query=null;
		}
		
		if(query!=null) {
				Connection localconn=null;
				Connection remotecon=null;
				try {
					localconn = DriverManager.getConnection("jdbc:mysql://"+MasterIp+":3306/ZS2024", MasterUser, MasterPass);
					remotecon=DriverManager.getConnection("jdbc:mysql://10.191.255.157:3306/ZS2024","Data","data@143");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("con catch");
					e.printStackTrace();
				}
				
				boolean status = universalChange(localconn, remotecon, true, query);
				if(status==false) {
					try
			        {
			             Class.forName("com.mysql.jdbc.Driver");
			             Connection con=DriverManager.getConnection("jdbc:mysql://"+MasterIp+":3306/ZS2024", MasterUser, MasterPass);
			             Statement st=con.createStatement();
			             System.out.println("connection established successfully...!!"); 


			             ResultSet rs = st.executeQuery("show tables");
//			             RequestDispatcher rd = req.getRequestDispatcher("/index.html");
//			             rd.include(req, res);

			             Connection localcon=DriverManager.getConnection("jdbc:mysql://10.191.255.157:3306/ZS2024","Data","data@143");
			             Statement localst = localcon.createStatement();
			             
			             Connection newcon=DriverManager.getConnection("jdbc:mysql://"+MasterIp+":3306/ZS2024", MasterUser, MasterPass);
			             Statement newst=newcon.createStatement();
			             
			                 while(rs.next())
			                 {
			                	 System.out.println("again");
			                	 String table = rs.getString(1);
			                	 
			                	 
			                	 ResultSet localrs = localst.executeQuery("show tables");
			                	 
			                	 
			                	 boolean check = false;
			                	 while(localrs.next()){
			                		 System.out.println(table);
				                	 String localtable = localrs.getString(1);
				                    
				                    if(table.equals(localtable)){
				                    	System.out.println("Exits");
				                    	check = true;
				                    	break;
				                    }
				                    else {
				                    	System.out.println("Not Exits");
				                    }
				                    
				//                	pw.println("<tr><td>"+rs.getObject(1)+"</td></tr>");
//				                    System.out.println("innerloop");
			                	 }
			                	 if(check==false){
			                		 boolean once=false;
			                		 ResultSet tableStrcture = newst.executeQuery("desc "+table);
			                		 int count=0;
			                		 while(tableStrcture.next()) {
			                    		 String field = tableStrcture.getString(1);
			                        	 String datatype = tableStrcture.getString(2);
			                        	 String key = tableStrcture.getString(4);
			                        	 if(count==0){
			                        		 if(key.equals("PRI") && once==false) {
			                        			 localst.executeUpdate("Create table "+table+"("+field+" "+datatype+" not null primary key)");
			                        			 once=true;
			                        		 }
//			                        		 else if(key.equals("MUL")) {
//			                        			 localst.executeUpdate("Create table "+table+"("+field+" "+datatype+" foreign key)");
//			                        		 }
			                        		 else {
			                        			 localst.executeUpdate("Create table "+table+"("+field+" "+datatype+" not null )");
			                        		 }
			                        		 
			                        		 count+=1;
			                        	 }
			                        	 else {
			                        		 if(key.equals("PRI")&& once==false) {
			                        			 localst.executeUpdate("alter table "+table+" add "+field+" "+datatype+"not null primary key");
			                        			 once=true;
			                        		 }
//			                        		 else if(key.equals("MUL")) {
//			                        			 localst.executeUpdate("alter table "+table+" add "+field+" "+datatype+" foreign key"); 
//			                        		 }
			                        		 else {
			                        			 localst.executeUpdate("alter table "+table+" add "+field+" "+datatype+" not null");
			                        		 }
			                        		  
			                        		 
			                        	 }
			                        	 
			                		 }
			                	 }
			                	
			                 }
			                 
			                 universalChange(localconn, remotecon, true, query);
			        }
			        catch (Exception e1){
			        	System.out.println("i am kutty catch");
			            e1.printStackTrace();
			        }
				}
				}

	}

}
