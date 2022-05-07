package infraestructure.repositories.passanger;

import infraestructure.model.PassangerJpaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PassangerCrudRepository extends CrudRepository<PassangerJpaModel, UUID> {
}
