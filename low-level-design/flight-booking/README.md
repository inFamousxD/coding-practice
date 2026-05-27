Flight
- id
- destination
- origin
- time
- Aircraft

Aircraft
- id
- List<Seat>

Seat
- id
- type: Enum{ECONOMY,FIRST_CLASS,BUSINESS}
- status: Enum{AVAILABLE,HELD,BOOKED}
- cost

SeatHoldService
- holdSeat(Seat seat, Flight flight): boolean
- releaseSeat(Seat seat, Flight flight): void (?) // called by either user cancellation, or hold expiry

FlightService
- checkSeatAvailability(Seat seat, Flight flight): boolean
- getFlights(origin, dest, date): List<Flight>

BookingService
- reserveSeat(Flight flight, Seat seat, Passenger passenger): Booking
- confirmBooking(Booking booking, Payment payment): Booking
- cancelBooking(Booking booking): void

Passenger
- id
- List<Booking>

Booking
- Flight flight
- Passenger p
- status: Enum{PENDING,SUCCESSFUL,CANCELLED}

Payment
- paymentDetails

PaymentService
- processPayment(Booking b): Payment
- refund(Booking b): void


---

1. User searches for flights
   1. getFlights(): Returns a list of Flights
2. User picks a seat
   1. reserveSeat(): calls holdSeat() -> if true, hold the seat; if false, exception
3. User initiates payment
   1. processPayment(): initiate payment
   2. if payment successful: call confirmBooking
   3. if no payment succeeds within HELD timeout, call cancelBooking() which calls refund()