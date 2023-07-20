package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.myConnection;
import model.contact;

public class getFeedbackDao {
	public static List<contact> getMessages() {
		Connection con = myConnection.getConnection();
		List<contact> lst = new ArrayList<contact>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM contactInfo order by email");

			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				contact c =new contact();
				c.setEmail(rs.getString("email"));
				c.setFullName(rs.getString("fullName"));
				c.setMessage(rs.getString("message"));
				lst.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lst;
	}

}
