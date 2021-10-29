package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Customer;
import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest {
    @Test
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(700_000L);
        payment.setCreditCard("4003781888329319");
        payment.setVirtualAccount("400378087832081093");
        payment.setCustomer(new Customer());

        validateWGroups(payment, CreditCardPaymentGroup.class);

    }
}
