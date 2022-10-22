package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.Ticket;

public interface TicketRepository {
  UUID update(Ticket ticket);

  List<Ticket> getByFlightId(UUID flightId)
    throws BusinessRuleValidationException;
}
