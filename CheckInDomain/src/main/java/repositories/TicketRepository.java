package repositories;

import core.BusinessRuleValidationException;
import model.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketRepository {

    UUID update(Ticket ticket);

    List<Ticket> getByFlightId(UUID flightId) throws BusinessRuleValidationException;
}
