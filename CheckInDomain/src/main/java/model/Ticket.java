package model;

import core.Entity;
import java.util.UUID;

public class Ticket extends Entity {

  Passanger passanger;
  UUID flightId;
  UUID bookingId;

  public Ticket(Passanger passanger, UUID flightId, UUID bookingId) {
    this.id = UUID.randomUUID();
    this.passanger = passanger;
    this.flightId = flightId;
    this.bookingId = bookingId;
  }

  public Ticket(UUID id, Passanger passanger, UUID flightId, UUID bookingId) {
    this.id = id;
    this.passanger = passanger;
    this.flightId = flightId;
    this.bookingId = bookingId;
  }

  public Passanger getPassanger() {
    return passanger;
  }

  public UUID getFlightId() {
    return flightId;
  }

  public UUID getBookingId() {
    return bookingId;
  }
}
