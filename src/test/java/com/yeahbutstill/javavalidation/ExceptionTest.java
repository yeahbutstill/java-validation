package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Person;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest {

    @Test
    void testException() {

        // expetasinya memang throw error
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });

    }
}
