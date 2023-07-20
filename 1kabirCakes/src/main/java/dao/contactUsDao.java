package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.contact;


public class contactUsDao {
	public int insertMsg(List<contact> lst, String fkEmail) {
		contact c = lst.get(0);
		Connection con = myConnection.getConnection();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO contactInfo (fullName, email, message, fkEmail) VALUES(?,?,?,?)");
			ps.setString(1, c.getFullName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getMessage());
			ps.setString(4, fkEmail);
			i = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
