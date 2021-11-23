package constrain;

import com.yeahbutstill.javavalidation.data.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
  generic parameternya pertama adalah annotation CheckPassword
  lalu setelah itu adalah Object yang akan divalidasinya yaitu Register
  mengapa begitu karena ini akan disimpan di level Class
*/
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.getPassword() == null || value.getRetypePassword() == null) {
            return true; // skip validation
        }
        return value.getPassword().equals(value.getRetypePassword());
    }
}
