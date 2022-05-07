package infraestructure.repositories.check.in;

import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PassangerJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CheckInCrudRepository extends CrudRepository<CheckInJpaModel, UUID> {

    CheckInJpaModel findByPassangerAndFlightId(PassangerJpaModel passanger, UUID flightId);
}
