package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.user;

public class searchUser {
	public user search(List<user> lst) {
		user u = lst.get(0);
		Connection con = myConnection.getConnection();
		
		String uname = null;
		int userRole = 0;
		String email = null;
		user uReturn = new user();
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where email = ? and pass = ?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			
//			record is present
			
			
			if(rs.next()) {
				uname = rs.getString(2); 
				userRole = rs.getInt("userRole");
				email = rs.getString("email");
				
				
				uReturn.setName(uname);
				uReturn.setUserRole(userRole);
				uReturn.setEmail(email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println();
		return uReturn;
	}
}
