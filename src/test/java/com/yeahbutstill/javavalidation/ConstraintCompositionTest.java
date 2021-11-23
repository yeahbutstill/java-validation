package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import com.yeahbutstill.javavalidation.groupconstraint.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest {

    @Test
    void testComposition() {

        Payment payment = new Payment();
        payment.setOrderId("123123123123123123123123123adasd");

        validateWGroups(payment, CreditCardPaymentGroup.class);

    }
}
