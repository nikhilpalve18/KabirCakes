package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.product;

public class addToCartDao {
	public int insertIntoCart(int pId, String email) {
		Connection con = myConnection.getConnection();
		int prodPrice = 0;
		String prodName = "";
		int cartTotal = 0;
		int quantity = 1;
		int i = 0;
		System.out.println(pId);
		System.out.println(email);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products where prodId=?");
			ps.setInt(1, pId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				prodPrice = rs.getInt("prodPrice");
				prodName = rs.getString("prodName");
				System.out.println(prodPrice);
				System.out.println(prodName);
			}
			
			ps = con.prepareStatement("SELECT * FROM cart where prodId=? and email=?");
			ps.setInt(1, pId);
			ps.setString(2, email);
			ResultSet rs1 = ps.executeQuery();
			int z = 0;
			if(rs1.next()) {
				cartTotal = rs1.getInt("total");
				cartTotal += prodPrice;
				quantity = rs1.getInt("quantity");
				if(quantity >= 5) {
					return 0;
				}
				quantity = quantity + 1;
				z = 1;
			}
			
			
			if(z == 1) {
				ps = con.prepareStatement("UPDATE cart SET total=?, quantity=? WHERE prodId=? AND email=?");
				ps.setInt(1, cartTotal);
				ps.setInt(2, quantity);
				ps.setInt(3, pId);
				ps.setString(4, email);
				i = ps.executeUpdate();
			}
			if(z == 0) {
				ps = con.prepareStatement("INSERT INTO cart VALUES (?,?,?,?,?,?)");
				ps.setInt(1, pId);
				ps.setString(2, email);
				ps.setString(3, prodName);
				ps.setInt(4, quantity);
				ps.setInt(5, prodPrice);
				ps.setInt(6, prodPrice);
				i = ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
