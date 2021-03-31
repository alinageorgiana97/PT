package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.*;
import dao.CustomerDAO;
import model.Customer;

public class CustomerBll {

	private List<Validator<Customer>> validators;
    

	public CustomerBll() {
		validators = new ArrayList<Validator<Customer>>();
		validators.add(new CustomerEmailValidator());
		validators.add(new CustomerNameValidator());
		
	}
	

	public Customer find(int id) {
		Customer ct = CustomerDAO.findById(id);
		if (ct == null) {
			throw new NoSuchElementException("The Customer with id =" + id + " was not found!");
		}
		return ct;
	}

	public int insert(Customer Customer) throws SQLException {
			for (Validator<Customer> v : validators) {
				v.validate(Customer);
			}
			return CustomerDAO.addCustomer(Customer);
		}

		
	public void delete(int id) {
		Customer customer = CustomerDAO.findById(id);
		if (customer == null) {
			throw new NoSuchElementException("The client with id = " + id + " was not found!");
		} else {
			CustomerDAO.removeCustomer(customer.getIdCustomer());
		}
	}
	
	public void update(Customer customer) {
		Customer c = CustomerDAO.findById(customer.getIdCustomer());
		if (c == null) {
			throw new NoSuchElementException("The client with id = " + customer.getIdCustomer() + " was not found!");
		} else {
			
			CustomerDAO.update(customer);
		}
	}
	public List<Customer> selectAllCustomers() throws SQLException {
		return CustomerDAO.listCustomers();
	}

	}


