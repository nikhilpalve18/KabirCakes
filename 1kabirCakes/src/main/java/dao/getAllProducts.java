package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.product;
import model.user;

public class getAllProducts {
	public static List<product> getProducts(String category) {

		Connection con = myConnection.getConnection();

		List<product> lst = new ArrayList<product>();
		try {
			PreparedStatement ps;
			if(category.equals("adminView")) {
				ps = con.prepareStatement("SELECT * FROM products");
			}
			else if(category.equals(null)) {
				ps = con.prepareStatement("SELECT * FROM products");				
			}
			else {				
				ps = con.prepareStatement("SELECT * FROM products where category=?");
				ps.setString(1, category);
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product p = new product();
				p.setProdId(rs.getInt("prodId"));
				p.setProdName(rs.getString("prodName"));
				p.setProdDesc(rs.getString("prodDesc"));
				p.setProdPrice(rs.getInt("prodPrice"));
				p.setCategory(rs.getString("category"));
				p.setImageFileName(rs.getString("ImageFileName"));
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	public static List<product> getProductsAdmin() {

		Connection con = myConnection.getConnection();

		List<product> lst = new ArrayList<product>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product p = new product();
				p.setProdId(rs.getInt("prodId"));
				p.setProdName(rs.getString("prodName"));
				p.setProdDesc(rs.getString("prodDesc"));
				p.setProdPrice(rs.getInt("prodPrice"));
				p.setCategory(rs.getString("category"));
				p.setImageFileName(rs.getString("ImageFileName"));
				System.out.println("image file name" + p.getImageFileName());
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	public static List<product> editProductFetchData(int prodId) {

		Connection con = myConnection.getConnection();

		List<product> lst = new ArrayList<product>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products where prodId = ?");
			ps.setInt(1, prodId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product p = new product();
				p.setProdId(rs.getInt("prodId"));
				p.setProdName(rs.getString("prodName"));
				p.setProdDesc(rs.getString("prodDesc"));
				p.setProdPrice(rs.getInt("prodPrice"));
				p.setCategory(rs.getString("category"));
				p.setImageFileName(rs.getString("ImageFileName"));
				System.out.println("image file name" + p.getImageFileName());
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
}
