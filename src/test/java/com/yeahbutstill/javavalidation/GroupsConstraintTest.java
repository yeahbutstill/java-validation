package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import com.yeahbutstill.javavalidation.groupconstraint.CreditCardPaymentGroup;
import com.yeahbutstill.javavalidation.groupconstraint.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupsConstraintTest extends AbstractValidatorTest {
    @Test
    void testCreditCardGroupsInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(200_000L);
        payment.setCreditCard("123");

        validateWGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testCreditCardGroupsValid() {
        Payment payment = new Payment();
        payment.setOrderId("0112");
        payment.setAmount(300_000L);
        payment.setCreditCard("4003786151823427");

        validateWGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("0113");
        payment.setAmount(500_000L);
        payment.setVirtualAccount("400378087832081093");

        validateWGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
