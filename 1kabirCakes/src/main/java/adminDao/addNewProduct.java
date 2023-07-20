package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.myConnection;
import model.product;

public class addNewProduct {
	public int insertProduct(product p) {
		Connection con = myConnection.getConnection();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO products ( category, prodName, prodDesc, prodPrice, imageFileName) VALUES(?,?,?,?,?)");
			ps.setString(1, p.getCategory());
			ps.setString(2, p.getProdName());
			ps.setString(3, p.getProdDesc());
			ps.setInt(4, p.getProdPrice());
			ps.setString(5, p.getImageFileName());
			
			i = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
