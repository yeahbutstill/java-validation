package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Person;
import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

public class MetaDataTest extends AbstractValidatorTest {

    @Test
    void testPerson() {

        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);

        for (PropertyDescriptor propertyDescriptor : ((jakarta.validation.metadata.BeanDescriptor) beanDescriptor).getConstrainedProperties()) {
            System.out.println(propertyDescriptor.getPropertyName());
            for (ConstraintDescriptor<?> constraintDescriptor : propertyDescriptor.getConstraintDescriptors()) {
                System.out.println(constraintDescriptor);
            }
        }

    }
}
