package com.example.book.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

	List<String> allowedCategories;

	public CategoryValidator() {
		allowedCategories = new ArrayList<>(Arrays.asList("smart phone", "tablet", "laptop", "SSD"));
	}

	@Override
	public void initialize(Category constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return allowedCategories.contains(value);
	}

}
