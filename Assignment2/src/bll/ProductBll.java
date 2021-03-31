package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.ProductPriceValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Products;


public class ProductBll {

private List<Validator<Products>> validators;
	
	public ProductBll() {
		validators = new ArrayList<Validator<Products>>();
		validators.add(new ProductPriceValidator());
		
	}
	
	public Products findProductById(int id) {
		Products product = ProductDAO.findById(id);
		if (product == null) {
			throw new NoSuchElementException("The product with id = " + id + " was not found!");
		}
		return product;
	}

	public int insertProduct(Products product) {
		for (Validator<Products> p : validators) {
			p.validate(product);
		}
		return ProductDAO.addProduct(product);
	}
		
	public void deleteProduct(int id) {
		Products product = ProductDAO.findById(id);
		if (product == null) {
			throw new NoSuchElementException("The product with id = " + id + " was not found!");
		} else {
			ProductDAO.delete(product.getIdProduct());
		}
	}
	
	public void updateProduct(Products product) {
		Products p = ProductDAO.findById(product.getIdProduct());
		if (p == null) {
			throw new NoSuchElementException("The product with id = " + product.getIdProduct() + " was not found!");
		} else {
			
			ProductDAO.update(product);
		}
	}
	
	
}



