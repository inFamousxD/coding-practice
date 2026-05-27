package models;

public class Payment {
    private final String transactionId;
    private final Double amount;
    private PaymentStatus status;
    private PaymentMethod method;

    public Payment(String transactionId, Double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        status = PaymentStatus.NOT_INITIATED;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentMethod getMethod() {
        return method;
    }
}

