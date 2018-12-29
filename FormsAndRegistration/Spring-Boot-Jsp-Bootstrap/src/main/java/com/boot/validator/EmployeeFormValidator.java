package com.boot.validator;

import com.boot.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Chaklader on Oct, 2017
 */
@Component
public class EmployeeFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");

        Employee emp = (Employee) obj;

        if (emp.getId() <= 0) {
            errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
    }
}
