package models;

public interface PaymentMethod {
    boolean pay(Double amount);
    void refund(Payment payment);
}
