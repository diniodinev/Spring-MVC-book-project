package com.example.book.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.example.book.domain.Product;

@Component
public class ProductImageValidator implements Validator {

	private long allowedSize = 1024 * 1024l;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		MultipartFile imageFile = product.getProductImage();

		if (allowedSize < imageFile.getSize()) {
			errors.rejectValue("productImage", "com.packt.webstore.validator.ProductImageValidator.message",
					new Object[] { String.valueOf(imageFile.getSize()) }, "");
		}
	}
}
