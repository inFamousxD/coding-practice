package models;

public class Payment {
    private final String paymentId;
    private PaymentMethod paymentMethod;

    public Payment(String paymentId, PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
