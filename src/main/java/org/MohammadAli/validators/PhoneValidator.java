package org.MohammadAli.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class PhoneValidator implements ConstraintValidator<Phone,String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneNumber == null) return false;
        if (phoneNumber.matches("09[1-7][0-9]\\d{7}$")) return true;
        return false;
    }
}
