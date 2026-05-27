package services;

import models.*;

import java.util.UUID;

public class PaymentService {
    private final SeatHoldService seatHoldService;

    public PaymentService() {
        this.seatHoldService = SeatHoldService.getInstance();
    }

    public void processPayment(Booking booking, PaymentMethod paymentMethod) {
        Payment payment = new Payment(UUID.randomUUID().toString(), booking.getSeat().getCost());
        payment.setMethod(paymentMethod);
        boolean paymentSuccessful = paymentMethod.pay(booking.getSeat().getCost());

        if (paymentSuccessful)
            booking.updateStatus(BookingStatus.SUCCESSFUL);
        else {
            booking.updateStatus(BookingStatus.CANCELLED);
            seatHoldService.releaseSeat(booking.getSeat());
        }

        booking.setPayment(payment);
    }

    public void refund(Booking booking, PaymentMethod paymentMethod) {
        booking.updateStatus(BookingStatus.CANCELLED);
        seatHoldService.releaseSeat(booking.getSeat());
        paymentMethod.refund(booking.getPayment());
    }
}
