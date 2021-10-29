package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import org.junit.jupiter.api.Test;

public class HibernateValidationConstrainTest extends AbstractValidatorTest {
    @Test
    void testHibernateValidatarConstraintInvalid() {

        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("0001");
        payment.setCreditCard("433");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstrainValid() {

        Payment payment = new Payment();
        payment.setAmount(10_000_000L);
        payment.setOrderId("0002");
        payment.setCreditCard("4895941804867435");

        validate(payment);

    }
}
