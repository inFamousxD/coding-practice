package models;

import java.time.LocalDate;

public class Flight {
    private final String flightId;

    private final String destination;
    private final String origin;
    private final LocalDate dateTime;

    private final Aircraft aircraft;

    public Flight(String flightId, Aircraft aircraft, String destination, String origin, LocalDate dateTime) {
        this.flightId = flightId;
        this.aircraft = aircraft;
        this.destination = destination;
        this.origin = origin;
        this.dateTime = dateTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }
}
