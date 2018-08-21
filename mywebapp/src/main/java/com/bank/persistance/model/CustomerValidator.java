package com.bank.persistance.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		Customer customer = (Customer) target;

		if (customer.getSsn() == null || customer.getSsn().length()<10) {

			errors.rejectValue("ssn", "register.ssn", "Invalid SSN");
		}

	}

}
