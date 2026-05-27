package services;

import models.Passenger;
import models.Seat;
import models.SeatStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class SeatHold {
    private final String holdId;
    private final Seat seat;
    private final String passengerId;
    private final LocalDateTime expiresAt;

    SeatHold(String holdId, Seat seat, String passengerId) {
        this.holdId = holdId;
        this.expiresAt = LocalDateTime.now().plusMinutes(10);
        this.seat = seat;
        this.passengerId = passengerId;
    }

    public String getHoldId() {
        return holdId;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getPassengerId() {
        return passengerId;
    }
}

public class SeatHoldService {
    // singleton
    public static volatile SeatHoldService instance;
    private final Map<String, SeatHold> activeSeatHolds = new ConcurrentHashMap<>();
    private final Map<String, ReentrantLock> activeLocks = new ConcurrentHashMap<>();

    private SeatHoldService() {}

    public static SeatHoldService getInstance() {
        if (instance == null) {
            synchronized (SeatHoldService.class) {
                if (instance == null) instance = new SeatHoldService();
            }
        }
        return instance;
    }

    public boolean holdSeat(Seat seat, Passenger passenger) {
        // check if seat is being held
        ReentrantLock lock = activeLocks.computeIfAbsent(seat.getSeatId(), id -> new ReentrantLock());
        try {
            lock.lock();
            // check if held
            SeatHold hold = activeSeatHolds.get(seat.getSeatId());

            if (hold == null || hold.getExpiresAt().isBefore(LocalDateTime.now())) {
                activeSeatHolds.remove(seat.getSeatId());
                SeatHold newHold = new SeatHold(UUID.randomUUID().toString(), seat, passenger.getPassengerId());
                activeSeatHolds.put(seat.getSeatId(), newHold);
                seat.setSeatStatus(SeatStatus.HELD);

                return true;
            }
        } finally {
            lock.unlock();
        }

        return false;
    }

    public void releaseSeat(Seat seat) {
        ReentrantLock lock = activeLocks.computeIfAbsent(seat.getSeatId(), id -> new ReentrantLock());

        try {
            lock.lock();
            // check if held
            SeatHold hold = activeSeatHolds.get(seat.getSeatId());

            if (hold != null) {
                activeSeatHolds.remove(seat.getSeatId());
                seat.setSeatStatus(SeatStatus.AVAILABLE);
            }
        } finally {
            lock.unlock();
        }
    }
}
