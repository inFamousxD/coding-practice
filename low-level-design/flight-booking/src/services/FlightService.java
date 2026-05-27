package services;

import models.Flight;
import models.Seat;
import models.SeatStatus;
import models.SeatType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightService {
    private final Map<String, List<Flight>> flightStore = new HashMap<>();

    public List<Flight> searchFlights(String dest, String origin, LocalDate time) {
        return flightStore.get(origin + ":" + dest + ":" + time);
    }

    public List<Seat> getAvailableSeats(Flight flight, SeatType type) {
        return flight.getAircraft().getSeats().stream().filter(seat -> seat.getSeatType() == type && seat.getSeatStatus() == SeatStatus.AVAILABLE).toList();
    }

    public void addFlights(Flight flight) {
        String key = flight.getOrigin() + ":" + flight.getDestination() + ":" + flight.getDateTime();
        flightStore.computeIfAbsent(key, k -> new ArrayList<>()).add(flight);
    }
}
