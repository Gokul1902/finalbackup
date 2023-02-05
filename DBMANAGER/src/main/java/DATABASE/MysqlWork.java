package DATABASE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;
import com.pastdev.jsch.DefaultSessionFactory;
import com.pastdev.jsch.command.CommandRunner;

/**
 * Servlet implementation class MysqlWork
 */
@WebServlet("/MysqlWork")
public class MysqlWork extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String worksql = request.getParameter("switch");
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
		String ip = (String)sess.getAttribute("ip");
	    String name = request.getParameter("lapusername");
	    String sqltype = request.getParameter("sqlType");
	    String password = request.getParameter("lappass");
	    ip="192.168.43.137";
	    
	    if(name.equals("") || password.equals("")) {
	    	RequestDispatcher rd = request.getRequestDispatcher("/mysql.html");
            rd.forward(request,response);
	    }
	    else {
	    	 DefaultSessionFactory sessionFactory = new DefaultSessionFactory(
	                 name, ip, 22
	         );
	         Map props = new HashMap<String, String>();
	         props.put("StrictHostKeyChecking", "no");
	         sessionFactory.setConfig(props);
	         sessionFactory.setPassword(password);

	         CommandRunner runner = new CommandRunner(sessionFactory);
	         

	         String command = "";
	         if(sqltype.equals("MySQL")) {
	        	 if(worksql.equals("Start")) {
	        		 command="sudo systemctl start mysql";
	        	 }
	        	 else if(worksql.equals("Stop")){
	        		 System.out.println("hello");
	        		 command="sudo systemctl stop mysql";
	        	 }
	        	 else {
	        		 command="sudo service mysql status ";
	        	 }
	         }
	         else {
	        	 if(worksql.equals("Start")) {
	        		 command="sudo systemctl start postgresql";
	        	 }
	        	 else if(worksql.equals("Stop")){
	        		 command="sudo systemctl stop postgresql";
	        	 }
	        	 else {
	        		 command="sudo service postgresql status ";
	        	 }
	         }
	         CommandRunner.ExecuteResult result = null;
	         CommandRunner.ExecuteResult statusresult = null;
	         
			try {
				result = runner.execute(command);
			} catch (JSchException | IOException e) {
				e.printStackTrace();
			}


	         if (result.getStderr().isEmpty()) {
	        	 try {
	        		 if(sqltype.equals("MySQL")) {
	        			 statusresult = runner.execute("sudo service mysql status ");
	        		 }
	        		 else {
	        			 statusresult = runner.execute("sudo service postgresql status ");
	        		 }
					
				} catch (JSchException | IOException e) {
					e.printStackTrace();
				}
	        	 if (statusresult.getStderr().isEmpty()) {
	        		 out.println(statusresult.getStdout());
	        	 }
	         } else {
	             out.println(result.getStderr());
	         }

	         runner.close();
	         
	    	
	    }

	}

}
