package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.cart;
import model.order;
import model.product;
import model.user;

public class addressPayment {
	public int insertAddress(List<user> lst) {
		Connection con = myConnection.getConnection();
		user u = lst.get(0);
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE users SET address=?, city=?, state=?, country = ? where email=?");
			ps.setString(1,u.getAddress());
			ps.setString(2,u.getCity());
			ps.setString(3,u.getState());
			ps.setString(4,u.getCountry());
			ps.setString(5, u.getEmail());
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int insertOrder(String email, List<order> lst) {
		Connection con = myConnection.getConnection();
		order o = lst.get(0);
		int i = 0;
		int orderId = 0;
		String status = "processing";
		try {
			System.out.println("------------!--------------------");
			PreparedStatement ps = con.prepareStatement("INSERT INTO orders(email, paymentMode, transactionId, orderDate, shippingDate, status) VALUES(?,?,?,CURRENT_TIMESTAMP,DATE_ADD(orderDate, INTERVAL 2 HOUR),?)");
			ps.setString(1,email);
			ps.setString(2,o.getPaymentMode());
			ps.setString(3,o.getTransactionId());
			ps.setString(4, status);
			i = ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("SELECT max(orderId) FROM orders");
			ResultSet rs = ps1.executeQuery();
			
			System.out.println("----------------------------");
			
			if(rs.next()) {
				orderId = rs.getInt(1);
				System.out.println("order Id" + orderId);
			}
			System.out.println("----------------------------");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;
	}
	
	public int insertOrderDetails(int orderId, List<cart> lst) {
		Connection con = myConnection.getConnection();
		int listSize = lst.size();
		int j = 0;
		
		try {
			for(int i=0; i<listSize; i++) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO orderDetails VALUES(?,?,?,?)");
				cart c = lst.get(i);
				ps.setInt(1, orderId);
				ps.setString(2, c.getProdName());
				ps.setInt(3, c.getQuantity());
				ps.setInt(4, c.getTotal());
				j = ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
	}
//	select orderId using transactionId which is unique and insert cart details from cart table into orderDetails table
//	and delete cart table details
	
	
	
}








