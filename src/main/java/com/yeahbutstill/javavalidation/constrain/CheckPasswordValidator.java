package com.yeahbutstill.javavalidation.constrain;

import com.yeahbutstill.javavalidation.data.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
  generic parameternya pertama adalah annotation CheckPassword
  lalu setelah itu adalah Object yang akan divalidasinya yaitu Register
  mengapa begitu karena ini akan disimpan di level Class
*/
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.getPassword() == null || value.getRetypePassword() == null) {
            return true; // skip validation
        }

        // Constraint Validator Context
        boolean isValid = value.getPassword().equals(value.getRetypePassword());

        if (!isValid) {
            // disable dulu message defaultnya
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password") // kita kasih tau kalau passwordnya salah
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword") // kita kasih tau kalau passwordnya salah
                    .addConstraintViolation();

        }

        return isValid;
    }
}
