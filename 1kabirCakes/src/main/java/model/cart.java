package model;

public class cart {
	int prodId;
	String email;
	String prodName;
	int quantity;
	int price;
	int total;
	
	public cart() {
		super();
	}

	public cart(int prodId, String email, String prodName, int quantity, int price, int total) {
		super();
		this.prodId = prodId;
		this.email = email;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
