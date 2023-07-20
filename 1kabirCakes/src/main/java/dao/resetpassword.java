package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.user;

public class resetpassword {
	public int resetpass(List<user> lst) {
		user u = lst.get(0);
		Connection con = myConnection.getConnection();

		int i = 0;
		try {
			PreparedStatement ps;
			ps = con.prepareStatement(
					"SELECT * FROM users where email=? and mobileNumber = ? and securityQuestion = ? and answer = ? ");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getMobileNumber());
			ps.setString(3, u.getSecurityQuestion());
			ps.setString(4, u.getAnswer());
			ResultSet rs = ps.executeQuery();

			// record is present

			if (rs.next()) {
				ps = con.prepareStatement("UPDATE users SET pass = ? WHERE email = ?");
				ps.setString(1, u.getPassword());
				ps.setString(2, u.getEmail());
				i = ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
