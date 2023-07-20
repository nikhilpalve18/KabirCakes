package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.myConnection;
public class deleteProductDao {
	public static int removeProduct(int prodId) {
		Connection con = myConnection.getConnection();
		
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE prodId = ?");
			ps.setInt(1, prodId);
			i = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
