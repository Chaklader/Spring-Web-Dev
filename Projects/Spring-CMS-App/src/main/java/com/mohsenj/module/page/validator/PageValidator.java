package com.mohsenj.module.page.validator;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.page.model.Page;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Page.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	//Content content = (Content) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "text.error.title.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "text.error.content.NotEmpty");

        /*
        if (content.getT().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        */
    }
}
