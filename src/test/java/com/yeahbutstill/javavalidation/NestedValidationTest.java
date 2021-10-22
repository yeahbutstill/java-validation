package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Address;
import com.yeahbutstill.javavalidation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNested() {

        Person person = new Person();
        person.setFirstName("Dani");
        person.setLastName("Setiawan");

        Address address = new Address();
        person.setAddress(address);

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation : validate) {
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println("====================================");
        }

    }
}
