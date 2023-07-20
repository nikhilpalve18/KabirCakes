package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.myConnection;
import model.product;

public class editProductDao {
	public static int editProduct(product p) {
		Connection con = myConnection.getConnection();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE products SET prodName=?, category=?, prodPrice=?, prodDesc=?, imageFileName=? WHERE prodId = ?");
			ps.setString(1, p.getProdName());
			ps.setString(2, p.getCategory());
			ps.setInt(3, p.getProdPrice());
			ps.setString(4, p.getProdDesc());
			ps.setString(5, p.getImageFileName());
			ps.setInt(6, p.getProdId());
			i = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
