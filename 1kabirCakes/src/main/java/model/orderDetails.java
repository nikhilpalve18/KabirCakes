package model;

public class orderDetails {
	private int orderId;
	private String prodName;
	private int quantity;
	private int subtotal;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	public orderDetails() {
		super();
	
	}
	
	public orderDetails(int orderId, String prodName, int quantity, int subtotal) {
		super();
		this.orderId = orderId;
		this.prodName = prodName;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	
	
}
