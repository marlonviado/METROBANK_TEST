package com.marlonviado.validator;

import java.util.regex.Pattern;
import com.marlonviado.annotation.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regexPattern = "^(.+)@(\\S+)$";
		return Pattern.compile(regexPattern)
			      .matcher(value)
			      .matches();
	}

}
