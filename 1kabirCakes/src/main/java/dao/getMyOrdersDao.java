package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.contact;
import model.order;

public class getMyOrdersDao {
	public List<order> getOrders(String email) {
		Connection con = myConnection.getConnection();
		List<order> lst = new ArrayList<order>();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE email = ? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				order o = new order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustId(rs.getString("email"));
				o.setPaymentMode(rs.getString("paymentMode"));
				o.setTransactionId(rs.getString("transactionId"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setShippingDate(rs.getString("shippingDate"));
				o.setStatus(rs.getString("status"));
				lst.add(o);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return lst;
	}
}
