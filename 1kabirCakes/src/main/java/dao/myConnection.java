package dao;
import java.sql.*;


public class myConnection {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kabircakes","Nikhil","niks");
			System.out.println(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return con;
	}
}