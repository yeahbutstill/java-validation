package com.yeahbutstill.javavalidation.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {
    @NotBlank(message = "order id must not blank")
    private String orderId;

    @NotNull(message = "amount must not null")
    @Range(min = 10_000L, max = 100_000_000L, message = "amount must between 10.000 and 100.000.000")
    private Long amount;

    @NotBlank(message = "credit card must not blank")
    @LuhnCheck(message = "credit card must valid number")
    private String creditCard;

    public Payment(String orderId, Long amount, String creditCard) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
    }

    public Payment() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
