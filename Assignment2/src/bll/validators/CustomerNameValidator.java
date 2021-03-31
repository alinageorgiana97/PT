package bll.validators;

import java.util.regex.Pattern;

import model.Customer;

public class CustomerNameValidator implements Validator<Customer>{
	private static final String NAME_PATTERN = "^[\\p{L} .'-]+$";

	public void validate(Customer t) {
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		if (!pattern.matcher(t.getName()).matches())
			throw new IllegalArgumentException("Name is not valid!");
		}
	}


