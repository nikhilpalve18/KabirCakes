package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.myConnection;
import model.cart;
import model.order;

public class getOrderDao {
	public static List<order> getAllOrders(String status) {
		Connection con = myConnection.getConnection();
		List<order> lst = new ArrayList<order>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE status = ? ORDER BY orderDate desc");
			ps.setString(1,status);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				order o = new order();
				o.setCustId(rs.getString("email"));
				o.setPaymentMode(rs.getString("paymentMode"));
				o.setTransactionId(rs.getString("transactionId"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setShippingDate(rs.getString("shippingDate"));
				o.setOrderId(rs.getInt("orderId"));
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
