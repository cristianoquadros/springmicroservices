package com.example.application.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.domain.entity.User;

@Component
public class UserValidator implements Validator {
	
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getUser().isEmpty()) {
            errors.rejectValue("input-user", "user.user.invalid", "Nome do usuário inválido");
        }
    }

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}
}