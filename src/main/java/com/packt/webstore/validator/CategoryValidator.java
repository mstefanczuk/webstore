package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    private List<String> allowedCategories;

    public CategoryValidator() {
        allowedCategories = new ArrayList<String>() {{
            add("Smart phone");
            add("Laptop");
            add("Tablet");
        }};
    }

    public void initialize(Category category) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return allowedCategories.contains(s);
    }
}
