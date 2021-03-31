package model;

public class Products {
	private int idProduct;
	private String name;
	private int price;
	private int quantity;

	public Products( int idProduct,String name, int price,int quantity) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Products(String name, int price,int quantity) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
