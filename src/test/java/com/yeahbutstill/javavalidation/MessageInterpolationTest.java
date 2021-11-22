package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {

        Payment payment = new Payment();
        payment.setOrderId("86512829511438687");
        payment.setVirtualAccount("31759106");
        payment.setAmount(304L);

        validateWGroups(payment, VirtualAccountPaymentGroup.class);

    }
}
