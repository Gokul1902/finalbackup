package DATABASE;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.cj.xdevapi.Statement;

@WebServlet ("/checker")
public class LogChecker extends HttpServlet {

	Connection con=null;
	java.sql.Statement st =null;
	String database="";
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String userIp = req.getRemoteAddr();
		HttpSession sess = req.getSession();
		HttpSession error = req.getSession();
		String ip = userIp;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		sess.setAttribute("ip", userIp);
		sess.setAttribute("username", username);
		sess.setAttribute("password", password);
		
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("error");
		}
		if(ip==" " || username==" " || password=="") {
			RequestDispatcher Rd = req.getRequestDispatcher("/login.jsp");
			Rd.forward(req, res);
		}
		else {
			try {
				con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/" + database, username, password);
                st = con.createStatement();
                RequestDispatcher Rd = req.getRequestDispatcher("/logsuccess.html");
    			Rd.forward(req, res);
			}
			catch (Exception e) {
				error.setAttribute("errorMessage", "Read Instructions"); 
				RequestDispatcher Rd = req.getRequestDispatcher("/login.jsp");
				Rd.forward(req, res);
			}
			
			
		}
		
	}

}
