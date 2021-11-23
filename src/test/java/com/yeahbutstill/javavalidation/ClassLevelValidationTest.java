package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Register;
import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest {

    @Test
    void testClassLevel() {

        Register register = new Register();
        register.setUsername("yeahbutstill");
        register.setPassword("dani");
        register.setRetypePassword("dani1");

        validate(register);

    }
}
