package constrain;

/**
 * Annotation CheckCase
 */

import enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.FIELD,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    // method untuk nanti dia milih upper atau lower
    CaseMode mode();

    // disini yang paling penting wajib ada 3 ini
    String message() default "invalid case";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
