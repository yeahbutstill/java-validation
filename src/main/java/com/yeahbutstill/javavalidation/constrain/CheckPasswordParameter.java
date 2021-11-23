package com.yeahbutstill.javavalidation.constrain;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    // tambahkan 2 buah field
    int passwordParam();

    int retypePasswordParam();

    String message() default "password is not same with retypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
