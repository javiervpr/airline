package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import builder.PassangerBuilder;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class TicketTests {

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID BOOKING_ID = UUID.randomUUID();
  private static final UUID ID = UUID.randomUUID();
  private Ticket ticket;

  @Test
  void testTicketCreation() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      ticket = new Ticket(passanger, FLIGHT_ID, BOOKING_ID);
    });
    assertNotNull(ticket.getId());
    assertEquals(FLIGHT_ID, ticket.getFlightId());
    assertEquals(BOOKING_ID, ticket.getBookingId());
    assertNotNull(ticket.getPassanger());
  }

  @Test
  void testTicketCreationWithId() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      ticket = new Ticket(ID, passanger, FLIGHT_ID, BOOKING_ID);
    });
    assertNotNull(ticket.getId());
    assertEquals(FLIGHT_ID, ticket.getFlightId());
    assertEquals(BOOKING_ID, ticket.getBookingId());
    assertEquals(ID, ticket.getId());
    assertNotNull(ticket.getPassanger());
  }
}
