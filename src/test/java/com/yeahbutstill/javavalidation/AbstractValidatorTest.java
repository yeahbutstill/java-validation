package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.extractor.DataIntegerValueExtractor;
import com.yeahbutstill.javavalidation.extractor.DataValueExtractor;
import com.yeahbutstill.javavalidation.extractor.EntryValueExtractorKey;
import com.yeahbutstill.javavalidation.extractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {
    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
        // tambahkan DataValueExtractor yang tadi telah kita buat untuk menvalidasi data container
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                // registrasikan EntryValueExtractor Key dan Value
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            System.out.println("========================");
        }
    }

    void validateWGroups(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            System.out.println("========================");
        }
    }
}
