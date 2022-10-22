package infraestructure.repositories.ticket;

import infraestructure.model.TicketJpaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TicketCrudRepository extends CrudRepository<TicketJpaModel, UUID> {

    List<TicketJpaModel> findByFlightId(UUID flightId);
}
