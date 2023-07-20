package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.myConnection;

public class updateStatusDao {
	public static int updateStatus(int orderId, String orderStatus) {
		Connection con = myConnection.getConnection();
		System.out.println(orderStatus);
		System.out.println(orderId);
		
		int i=0;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE orders set status = ? WHERE orderId = ?");
			ps.setString(1, orderStatus);
			ps.setInt(2, orderId);
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
