package models;

public class PaymentByCard implements PaymentMethod {
    @Override
    public boolean pay(Double amount) {
        return true;
    }

    @Override
    public void refund(Payment payment) {
        return;
    }
}
