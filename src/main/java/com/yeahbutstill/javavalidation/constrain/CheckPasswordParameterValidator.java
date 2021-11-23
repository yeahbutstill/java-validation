package com.yeahbutstill.javavalidation.constrain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
// harus menambahkan annotation ini untuk memberi tahu Bean Validation
// kalau ini digunakan untuk validasi Cross Parameter
// Dan disini juga harus tambahkan value yang akan divalidasi adalah ArrayOfObject
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    private int passwordParam;

    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        passwordParam = constraintAnnotation.passwordParam();
        retypePasswordParam = constraintAnnotation.retypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        String password = (String) value[passwordParam];
        String retypePasasword = (String) value[retypePasswordParam];

        if (password == null || retypePasasword == null) {
            return true; // skip validation
        }

        return password.equals(retypePasasword);
    }
}
