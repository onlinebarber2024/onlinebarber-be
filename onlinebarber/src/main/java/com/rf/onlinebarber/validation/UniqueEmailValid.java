package com.rf.onlinebarber.validation;

import com.rf.onlinebarber.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValid implements ConstraintValidator<UniqueEmail,String> {
    private final UserRepository repository;

    public UniqueEmailValid(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByEmail(s);
    }
}
