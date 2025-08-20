package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
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
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {
                int updatedProductAmount = product.getInv() - myProduct.getInv();
                if (p.getInv() < updatedProductAmount){
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Not enough " + p.getName() + " for order").addConstraintViolation();
                    return false;
                }else if (updatedProductAmount < p.getMinInventoryValue()) {
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Order takes part \"" + p.getName() + "\" below minimum inventory").addConstraintViolation();
                    return false;
                }
            }
            return true;
        }
        else{
                return true;
            }
    }
}
