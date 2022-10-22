package infraestructure.repositories.ticket;

import infraestructure.model.TicketJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TicketCrudRepository
  extends CrudRepository<TicketJpaModel, UUID> {
  List<TicketJpaModel> findByFlightId(UUID flightId);
}
