package com.caveofprogramming.spring.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/*
	com.spring.test.validation.ValidEmail contains Constraint 
	annotation, but does not contain a payload parameter.
*/ 


/*
	SEVERE: Servlet.service() for servlet [offers] in context with path [/MySpring] threw exception 	

	java.lang.IllegalStateException: An Errors/BindingResult argument is 
	expected to be declared immediately after the model attribute, the @RequestBody or 
	the @RequestPart arguments to which they apply: public 

	java.lang.String com.spring.test.controllers.OffersController.doCreate
	
	( 
		org.springframework.ui.Model,
		org.springframework.validation.BindingResult,
		com.spring.test.dao.Offer
	)
*/


@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = com.caveofprogramming.spring.web.validation.ValidEmailImpl.class)
public @interface ValidEmail {

	String message() default "This does not appear to be a valid email address";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int min() default 5;
}
