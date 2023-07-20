package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class getCartDao {
	public static List<cart> getCartItems(String email) {
		Connection con = myConnection.getConnection();
		List<cart> lst = new ArrayList<cart>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM cart where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cart c = new cart();
				c.setProdId(rs.getInt("prodId"));
				c.setEmail(rs.getString("email"));
				c.setProdName(rs.getString("prodName"));
				c.setQuantity(rs.getInt("quantity"));
				c.setPrice(rs.getInt("price"));
				c.setTotal(rs.getInt("total"));
				lst.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fetching done");
		return lst;
	}
	
	public static int removeFromCart(String email, String prodId) {
		Connection con = myConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM cart where email = ? and prodId = ?");
			ps.setString(1, email);
			ps.setString(2, prodId);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static int emptyCart(String email) {
		Connection con = myConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM cart where email = ?");
			ps.setString(1, email);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<cart> incDecCart(String email, String prodId, String incDec){
		List<cart> lst = new ArrayList<cart>();
		int price = 0;
		int total = 0;
		int quant = 0;
//		int finalTotal = 0;
		
		try{
			Connection con = myConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cart where email='"+email+"' and prodId='"+prodId+"' ");
			while(rs.next()){
				price = rs.getInt("price");
				total = rs.getInt("total");
				quant = rs.getInt("quantity");
			}
			
			if(quant == 5 && incDec.equals("inc")) {
				return lst;
			}
			
			if(quant == 1 && incDec.equals("dec")){
				return lst;
			}
			
			else if(quant!=1 && incDec.equals("dec")){
				total = total-price;
				quant -= 1;
				st.executeUpdate("UPDATE cart SET total='"+total+"',quantity='"+quant+"' WHERE email='"+email+"' AND prodId='"+prodId+"' ");
			}
			else{
				total = total+price;
				quant += 1;
				st.executeUpdate("UPDATE cart SET total='"+total+"',quantity='"+quant+"' WHERE email='"+email+"' AND prodId='"+prodId+"' ");
			}
			lst = getCartDao.getCartItems(email);
		}
			catch(Exception e){
				System.out.println(e);
			}
		
		return lst;
	}
}
