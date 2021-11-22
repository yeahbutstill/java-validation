package constrain;

import enums.CaseMode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * dia harus implements ConstraintValidator
 * dia adalah generic ada 2 type data
 * yang pertama Annotationnya (CheckCase)
 * kedua adalah type data apa yang bisa ditampung (String)
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true; // skip validation jika value adalah null
        }

        if (caseMode == CaseMode.UPPER) {
            return value.equals(value.toUpperCase());
        } else if (caseMode == CaseMode.LOWER) {
            return value.equals(value.toLowerCase());
        }
        return false;
    }
}
