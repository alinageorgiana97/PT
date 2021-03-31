package bll.validators;

import model.Products;

public class ProductPriceValidator implements Validator<Products>{
	
		
		private static final String PRICE_PATTERN = "[0-9]+";
		
		public void validate(Products p) {
			if (!(new Integer(p.getPrice()).toString().matches(PRICE_PATTERN))) {
				throw new IllegalArgumentException("Price is not valid!");
			}
		}
}


