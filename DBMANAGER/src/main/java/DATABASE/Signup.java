package DATABASE;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/Signpage")
public class Signup extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String processType = request.getParameter("type");
		System.out.println(processType);
		HttpSession sess = request.getSession();
		HttpSession mess = request.getSession();
		HttpSession login = request.getSession();
		sess.setAttribute("MasterIp", "192.168.43.137");
		sess.setAttribute("MasterUser", "test");
		sess.setAttribute("MasterPass", "Amma@143");
		String MasterIp = (String)sess.getAttribute("MasterIp");
		String MasterUser =(String)sess.getAttribute("MasterUser");
		String MasterPass = (String)sess.getAttribute("MasterPass");
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	con = DriverManager.getConnection("jdbc:mysql://"+MasterIp+":3306/loguser", MasterUser, MasterPass);
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if(processType.equals("login")) {
			String logname = request.getParameter("logname");
			String logpass = request.getParameter("logpass");	
			ResultSet rs;
			boolean done=false;
			try {
				rs = st.executeQuery("select * from logdetail;");
			    while (rs.next()) {
		        	if(rs.getObject(1).equals(logname) && rs.getObject(2).equals(logpass)) {
		        		login.setAttribute("currentusername", logname);
		        		login.setAttribute("currentuserpass", logpass);
		              RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		              rd.forward(request,response);
		              done=true;
		        	}
		     }
			} catch (SQLException | ServletException | IOException  e) {
				mess.setAttribute("logmessage", "Enter a wrong username or password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	             rd.forward(request,response);
        		
			}
			if(done==false) {
				mess.setAttribute("logmessage", "The username or password is not available");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	             rd.forward(request,response);
			}

	    
			
		}
		else if(processType.equals("logout")) {
			login.removeAttribute("currentusername");
    		login.removeAttribute("currentuserpass");
    		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
		}
		else {
			String signname = request.getParameter("signname");
			String signpass = request.getParameter("signpass");
			String signmail = request.getParameter("signmail");
			try {
				st.executeUpdate("insert into logdetail values ("+"'"+signname+"'"+","+"'"+signpass+"'"+","+"'"+signmail+"'"+")");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
	            rd.forward(request,response);
			}
			catch (Exception e) {
				mess.setAttribute("signmessage", "The username or password or email is not available");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	            rd.forward(request,response);
			}
		}
	}

}
