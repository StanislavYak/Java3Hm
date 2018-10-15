package ru.hm.hm7;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriorityValidator implements ConstraintValidator<Test, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value > 0 && value <= 10;
    }
}