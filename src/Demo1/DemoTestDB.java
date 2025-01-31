package Demo1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTestDB {
	
	// Main Method
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Setup the environment - Query | Select Statement
		String query = "SELECT * FROM university.students WHERE gpa > '3.40';";
		
		// Server Details: URL - UserName - Password
		String url = "jdbc:mysql://xxx:xxx";
		String username = "xxx";
		String password = "xxxx";
		
		//Import Java SQL Driver Manager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Import Java SQL Connection
		Connection con = DriverManager.getConnection(url, username, password);
		
		// Import Java SQL Statement
		Statement stm = con.createStatement();
		
		// Import Java SQL ResultSet
		ResultSet rs = stm.executeQuery(query);
		
		// While Loop - Loop through the Records
		while (rs.next()) {
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getString("last_name"));
			System.out.println(rs.getString("gender"));
			System.out.println(rs.getString("major"));
			System.out.println(rs.getString("gpa"));
			System.out.println("*************");
		}
		
		// Close Connection - Close Statement - Close ResultSet
		con.close();
		stm.close();
		rs.close();
		
	}

}
