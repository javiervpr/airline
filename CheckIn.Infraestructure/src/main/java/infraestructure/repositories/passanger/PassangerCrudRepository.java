package infraestructure.repositories.passanger;

import infraestructure.model.PassangerJpaModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface PassangerCrudRepository
  extends CrudRepository<PassangerJpaModel, UUID> {}
