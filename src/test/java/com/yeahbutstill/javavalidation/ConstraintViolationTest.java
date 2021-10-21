package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testConstraintViolation() {

        Person person = new Person();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertEquals(2, constraintViolations.size());

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            // Object Metadata
            System.out.println("Message : " + constraintViolation.getMessage());
            System.out.println("Bean : " + constraintViolation.getLeafBean());
            System.out.println("Annotation Constraint : " + constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value : " + constraintViolation.getInvalidValue());
            constraintViolation.getPropertyPath().forEach(node -> System.out.println("Path : " + node.getName()));
            System.out.println("======================================");
        }

    }

    @Test
    void testConstraintViolationSize() {

        Person person = new Person();
        person.setFirstName("DaniDaniDaniDaniDaniDaniDaniDaniDaniDaniDaniDani");
        person.setLastName("DaniDaniDaniDaniDaniDaniDaniDaniDaniDaniDaniDani");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertEquals(2, constraintViolations.size());

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            // Object Metadata
            System.out.println("Message : " + constraintViolation.getMessage());
            System.out.println("Bean : " + constraintViolation.getLeafBean());
            System.out.println("Annotation Constraint : " + constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value : " + constraintViolation.getInvalidValue());
            constraintViolation.getPropertyPath().forEach(node -> System.out.println("Path : " + node.getName()));
            System.out.println("======================================");
        }

    }

    @Test
    void testConstraintViolationSuccess() {

        Person person = new Person();
        person.setFirstName("Dani");
        person.setLastName("Setiawan");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertEquals(0, constraintViolations.size());

    }
}
