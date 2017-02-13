package com.example.book.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.book.domain.Product;
import com.example.book.exception.ProductNotFoundException;
import com.example.book.service.ProductService;

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
	@Autowired
	private ProductService productService;

	private static final Logger LOG = LoggerFactory.getLogger(ProductIdValidator.class);

	@Override
	public void initialize(ProductId constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the
		// constraint annotation for any sensible default values.
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoundException e) {
		//	LOG.debug("The product name is invalid", e);
			return true;
		}
		if (product != null) {
			return false;
		}
		return true;
	}
}