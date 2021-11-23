package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest {

    @Test
    void testCrossParameter() throws NoSuchMethodException {

        // kita buat objectnya
        UserService userService = new UserService();

        // kita buat methodnya
        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "dani";
        String password = "1212312";
        String retypePassword = "12312312312321";

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, method, new Object[]{
                        username, password, retypePassword
                });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=============================");
        }

    }
}
