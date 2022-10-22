package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import infraestructure.model.PassangerJpaModel;
import infraestructure.model.TicketJpaModel;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class TicketJpaModelTest {

  @Test
  void testTicketJpaModel() {
    UUID id = UUID.randomUUID();
    UUID flightId = UUID.randomUUID();
    UUID bookingId = UUID.randomUUID();
    UUID passengerId = UUID.randomUUID();
    PassangerJpaModel passangerJpaModel = new PassangerJpaModel();
    passangerJpaModel.setId(passengerId);

    TicketJpaModel ticketJpaModel = new TicketJpaModel();
    ticketJpaModel.setId(id);
    ticketJpaModel.setBookingId(bookingId);
    ticketJpaModel.setFlightId(flightId);
    ticketJpaModel.setPassenger(passangerJpaModel);

    assertEquals(flightId, ticketJpaModel.getFlightId());
    assertEquals(bookingId, ticketJpaModel.getBookingId());
    assertEquals(id, ticketJpaModel.getId());
    assertEquals(passangerJpaModel, ticketJpaModel.getPassenger());
  }
}
