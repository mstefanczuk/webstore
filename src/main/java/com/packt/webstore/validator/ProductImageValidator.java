package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductImageValidator implements Validator {
    private Long allowedSize;

    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        if(product.getProductImage().getSize() > allowedSize) {
            errors.rejectValue("productImage", "com.packt.webstore.validator.ProductImageValidator.message");
        }
    }

    public void setAllowedSize(Long allowedSize) {
        this.allowedSize = allowedSize;
    }
}
