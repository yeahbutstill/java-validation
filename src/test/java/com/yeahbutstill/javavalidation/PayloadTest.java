package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Customer;
import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest {

    @Test
    void testPayload() {

        Payment payment = new Payment();
        payment.setOrderId("2159");
        payment.setAmount(10_000_000L);
        payment.setCreditCard("400");
        payment.setCustomer(new Customer());

        Set<ConstraintViolation<Object>> violationSet = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violationSet) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class){
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }
            System.out.println("==============================================");
        }
    }
}
