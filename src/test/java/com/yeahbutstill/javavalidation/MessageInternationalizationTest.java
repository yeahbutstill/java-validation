package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class MessageInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testI18N() {

        /*
          cukup localnya diganti defaultnya kemana,
          dengan otomatis nanti dia akan mengabil validasi message _in_ID
          yang sama dengan default localnya
         */
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("213123123123123123123");
        payment.setAmount(10L);

        validateWGroups(payment, CreditCardPaymentGroup.class);

    }
}
