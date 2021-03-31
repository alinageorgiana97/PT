package model;

public class Order {
	private int idOrder;
	
	private int idProduct;
	private int idCustomer;
	private String submissionDate;

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Order(int idOrder, int idProduct, int idCustomer, String submissionDate) {
		super();
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.idCustomer = idCustomer;
		this.submissionDate = submissionDate;
	}

}
