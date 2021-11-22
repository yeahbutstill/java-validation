package com.yeahbutstill.javavalidation.data;

import constrain.CheckCase;
import enums.CaseMode;
import groupconstraint.CreditCardPaymentGroup;
import groupconstraint.VirtualAccountPaymentGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import payload.EmailErrorPayload;

public class Payment {

    @CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
    mode = CaseMode.UPPER, message = "{order.id.upper}")
    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.notblank}")
    @Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 1, max = 10, message = "{order.id.size}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{amount.notnull}")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L, max = 100_000_000L, message = "{amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card must not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "credit card must valid number", payload = {EmailErrorPayload.class})
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account must not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class}, message = "customer can not null")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Payment(String orderId, Long amount, String creditCard, String virtualAccount, Customer customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
        this.virtualAccount = virtualAccount;
        this.customer = customer;
    }

    public Payment() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
