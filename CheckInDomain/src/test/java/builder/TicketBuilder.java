package builder;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Passanger;
import model.Ticket;

public class TicketBuilder {

  private Passanger passanger;
  private UUID flightId = UUID.randomUUID();
  private UUID bookingId = UUID.randomUUID();
  private UUID id = UUID.randomUUID();

  public Ticket build() throws BusinessRuleValidationException {
    if (this.passanger == null) this.passanger = new PassangerBuilder().build();
    return new Ticket(id, passanger, flightId, bookingId);
  }

  public TicketBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TicketBuilder withPassanger(Passanger passanger) {
    this.passanger = passanger;
    return this;
  }

  public TicketBuilder withFlightId(UUID flightId) {
    this.flightId = flightId;
    return this;
  }

  public TicketBuilder withBookingId(UUID bookingId) {
    this.bookingId = bookingId;
    return this;
  }
}
