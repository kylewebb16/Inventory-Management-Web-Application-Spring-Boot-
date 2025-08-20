package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    private static final Logger log = LoggerFactory.getLogger(InventoryValidator.class);
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        // ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        int currentInv = part.getInv();
        // Make sure inventory is between min and max value
        if (currentInv < part.getMinInventoryValue()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix inventory value such that it is greater than the minimum").addConstraintViolation();
            return false;
        } else if (currentInv > part.getMaxInventoryValue()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix inventory value such that it is less than the maximum").addConstraintViolation();
            return false;
        }else {
            return true;
        }
    }
}
