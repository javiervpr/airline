package repositories;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Passanger;

public interface PassangerRepository {
  UUID update(Passanger passanger);

  Passanger get(UUID id) throws BusinessRuleValidationException;
}
