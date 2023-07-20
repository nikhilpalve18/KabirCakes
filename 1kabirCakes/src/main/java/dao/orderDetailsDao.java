package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.orderDetails;
import model.user;

public class orderDetailsDao {
	public List<user> getUserDetails(String email) {
		List<user> lst = new ArrayList<user>();
		Connection con = myConnection.getConnection();
		
		user u = new user();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM users WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setCountry(rs.getString("country"));
				u.setAddress(rs.getString("address"));
				u.setEmail(email);
				u.setMobileNumber(rs.getString("mobileNumber"));
				u.setCity(rs.getString("city"));
				u.setState(rs.getString("state"));
				lst.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lst;
	}
	
	public List<orderDetails> getOrderDetails(int orderId) {
		List<orderDetails> lst = new ArrayList<orderDetails>();
		Connection con = myConnection.getConnection();
		
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM orderDetails WHERE orderId = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderDetails o = new orderDetails();
				o.setOrderId(orderId);
				o.setProdName(rs.getString("productName"));
				o.setQuantity(rs.getInt("quantity"));
				o.setSubtotal(rs.getInt("subtotal"));
				lst.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lst;
	}
}
