package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import com.yeahbutstill.javavalidation.groupconstraint.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest {
    @Test
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(450_500L);
        payment.setCreditCard("4003781888329319");
        payment.setVirtualAccount("400378087832081093");

        validateWGroups(payment, PaymentGroup.class);

    }
}
