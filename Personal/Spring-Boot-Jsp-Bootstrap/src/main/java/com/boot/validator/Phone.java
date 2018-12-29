package com.boot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Chaklader on Oct, 2017
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "Phone is not in valid format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
