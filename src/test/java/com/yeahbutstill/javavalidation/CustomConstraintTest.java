package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("eko");

        validateWGroups(payment, CreditCardPaymentGroup.class);

    }
}
