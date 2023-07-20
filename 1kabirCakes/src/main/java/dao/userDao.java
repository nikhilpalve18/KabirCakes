package dao;

import java.sql.*;
import java.util.List;

import model.user;

public class userDao {	
	public int createUser(List<user> lst) {
		user u = lst.get(0);
		Connection con = myConnection.getConnection();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO users (uName, email, mobileNumber, securityQuestion, answer, pass, address, city, state, country, userRole) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getMobileNumber());
			ps.setString(4, u.getSecurityQuestion());
			ps.setString(5, u.getAnswer());
			ps.setString(6,u.getPassword());
			ps.setString(7,u.getAddress());
			ps.setString(8,u.getCity());
			ps.setString(9,u.getState());
			ps.setString(10,u.getCountry());
			ps.setInt(11,2);
			
			i = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
