import models.*;
import services.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FlightBookingSystem {
    public static void main(String[] args) {

        // --- Setup ---
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        // Create aircraft with seats
        List<Seat> seats = List.of(
                new Seat(UUID.randomUUID().toString(), SeatType.ECONOMY, 199.99),
                new Seat(UUID.randomUUID().toString(), SeatType.ECONOMY, 199.99),
                new Seat(UUID.randomUUID().toString(), SeatType.BUSINESS, 499.99)
        );
        Aircraft aircraft = new Aircraft(UUID.randomUUID().toString(), seats);

        // Create and register flight
        Flight flight = new Flight(
                UUID.randomUUID().toString(),
                aircraft,
                "NYC", "LAX",
                LocalDate.of(2026, 6, 1)
        );
        flightService.addFlights(flight);

        // Create passenger
        Passenger passenger = new Passenger(UUID.randomUUID().toString());

        // --- Happy path ---
        System.out.println("=== Searching flights ===");
        List<Flight> results = flightService.searchFlights("NYC", "LAX", LocalDate.of(2026, 6, 1));
        System.out.println("Flights found: " + results.size());

        System.out.println("\n=== Getting available economy seats ===");
        List<Seat> availableSeats = flightService.getAvailableSeats(flight, SeatType.ECONOMY);
        System.out.println("Available economy seats: " + availableSeats.size());

        System.out.println("\n=== Reserving seat ===");
        Seat chosenSeat = availableSeats.get(0);
        Booking booking = bookingService.reserveFlight(flight, chosenSeat, passenger);
        System.out.println("Booking status: " + booking.getStatus()); // PENDING
        System.out.println("Seat status: " + chosenSeat.getSeatStatus()); // HELD

        System.out.println("\n=== Processing payment ===");
        PaymentMethod paymentMethod = new PaymentByCard();
        paymentService.processPayment(booking, paymentMethod);
        System.out.println("Booking status: " + booking.getStatus()); // SUCCESSFUL

        System.out.println("\n=== Cancelling booking ===");
        bookingService.cancelBooking(booking, paymentService);
        System.out.println("Booking status: " + booking.getStatus()); // CANCELLED
        System.out.println("Seat status: " + chosenSeat.getSeatStatus()); // AVAILABLE
    }
}