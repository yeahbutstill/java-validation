package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.data.Payment;
import groupconstraint.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

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

    @Test
    void testMessageInterpolator() {
        /*
          Sebenernya ini tidak di rekomendasikan, tapi ini satu cara yang
          lumayan sulit, namun lebih flexible dengan menggunakan MessageInterpolator
          secara langsung. tapi sangat sulit karena kita harus membuat context secara
          manual untuk MesaageInterpolator dengan menggunakan parameter Locale di
          MessageInterpolator

        */
        Payment payment = new Payment();
        payment.setOrderId("3231231231231231231231");
        payment.setAmount(10L);

        Locale locale = new Locale("in", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println(message);
            System.out.println("============================");
        }

    }
}
