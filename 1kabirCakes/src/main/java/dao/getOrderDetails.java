package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.orderDetails;

public class getOrderDetails {
	public static List<orderDetails> getDetails(int orderId) {
		Connection con = myConnection.getConnection();
		List<orderDetails> lst = new ArrayList<orderDetails>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM orderDetails where orderId = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				orderDetails o = new orderDetails();
				o.setOrderId(rs.getInt("orderId"));
				o.setProdName(rs.getString("productName"));
				o.setQuantity(rs.getInt("quantity"));
				o.setSubtotal(rs.getInt("subTotal"));
				lst.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fetching done");
		return lst;
	}
	
}
