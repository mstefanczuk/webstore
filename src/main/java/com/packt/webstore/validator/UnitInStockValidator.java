package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class UnitInStockValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        if(product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0 && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "com.packt.webstore.validator.UnitsInStockValidator.message");
        }
    }
}
