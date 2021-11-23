package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Address;
import com.yeahbutstill.javavalidation.data.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("Dani");
        person.setLastName("Setiawan");
        person.setAddress(new Address());
        person.getAddress().setCity("Citayam");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Komp.Depag A 23 RT/RW 001/015 Pabuaran Bojong Gede");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("    ");
        person.getHobbies().add("Gaming");

        validate(person);
    }
}
