package model;

public class Customer {
	private int idCustomer;
	private String name;
	private String address;
	private String email;

	public Customer(int idCustomer,String name, String address, String email) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	public Customer(String name, String address, String email) {
		
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public int getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", address=" + address + ", email=" + email
				+ "]";
	}

}
