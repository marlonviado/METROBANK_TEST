package com.marlonviado.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.marlonviado.validator.ValidEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidEmailValidator.class)
public @interface ValidEmail {
	
	public String message() default "Email is required field";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
