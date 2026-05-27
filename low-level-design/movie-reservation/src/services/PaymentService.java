package services;

import models.*;

import java.util.UUID;

public class PaymentService {
    private final SeatHoldService seatHoldService = SeatHoldService.getSeatHoldServiceInstance();

    public Payment processPayment(Reservation reservation, PaymentMethod paymentMethod) {
        Payment payment = new Payment(UUID.randomUUID().toString(), paymentMethod);
        payment.setPaymentMethod(new PayByCard());
        boolean paymentSuccessful = payment.getPaymentMethod().pay(reservation.getSeat().getCost());

        if (paymentSuccessful) {
            reservation.setReservationStatus(ReservationStatus.SUCCESSFUL);
        } else {
            reservation.setReservationStatus(ReservationStatus.CANCELLED);
            seatHoldService.releaseSeat(reservation.getSeat());
        }

        return payment;
    }

    public void refund(Reservation reservation, PaymentMethod paymentMethod) {
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        seatHoldService.releaseSeat(reservation.getSeat());
        paymentMethod.refund(reservation.getSeat().getCost());
    }
}
