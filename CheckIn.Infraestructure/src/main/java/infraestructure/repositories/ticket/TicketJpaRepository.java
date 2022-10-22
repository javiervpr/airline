package infraestructure.repositories.ticket;

import core.BusinessRuleValidationException;
import infraestructure.model.TicketJpaModel;
import infraestructure.utils.TicketUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TicketRepository;

public class TicketJpaRepository implements TicketRepository {

  @Autowired
  private TicketCrudRepository ticketCrudRepository;

  @Override
  public UUID update(Ticket ticket) {
    TicketJpaModel ticketJpaModel = TicketUtils.ticketToJpaEntity(ticket);
    return ticketCrudRepository.save(ticketJpaModel).getId();
  }

  @Override
  public List<Ticket> getByFlightId(UUID flightId)
    throws BusinessRuleValidationException {
    List<TicketJpaModel> jpaModels = ticketCrudRepository.findByFlightId(
      flightId
    );
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    List<Ticket> tickets = new ArrayList<>();
    for (TicketJpaModel jpaModel : jpaModels) {
      tickets.add(TicketUtils.jpaModelToTicket(jpaModel));
    }
    return tickets;
  }
}
