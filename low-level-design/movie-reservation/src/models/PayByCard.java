package models;

public class PayByCard implements PaymentMethod {
    public boolean pay(Double amount) {
        return true;
    }

    public void refund(Double amount) {
    }
}
