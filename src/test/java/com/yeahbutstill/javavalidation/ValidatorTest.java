package com.yeahbutstill.javavalidation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void testValidator() {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        Validator validator = validatorFactory.getValidator();
        Assertions.assertNotNull(validator);

        validatorFactory.close();

    }
}
