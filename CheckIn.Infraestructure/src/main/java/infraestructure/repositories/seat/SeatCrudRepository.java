package infraestructure.repositories.seat;

import infraestructure.model.SeatJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatCrudRepository extends CrudRepository<SeatJpaModel, UUID> {
  List<SeatJpaModel> findByFlightIdAndStatus(UUID flight, String status);
}
