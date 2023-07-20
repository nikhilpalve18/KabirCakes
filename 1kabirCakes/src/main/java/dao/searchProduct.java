package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.product;

public class searchProduct {
	public static List<product> search(String searchText, String category) {
		Connection con = myConnection.getConnection();
		List<product> lst = new ArrayList<product>();
		
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM products where prodName LIKE ? AND category = ?");
			ps.setString(1, "%" + searchText + "%");
			ps.setString(2, category);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				product p = new product();
				p.setProdId(rs.getInt("prodId"));
				p.setProdName(rs.getString("prodName"));
				p.setProdDesc(rs.getString("prodDesc"));
				p.setProdPrice(rs.getInt("prodPrice"));
				p.setCategory(rs.getString("category"));
				p.setImageFileName(rs.getString("imageFileName"));
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
}
