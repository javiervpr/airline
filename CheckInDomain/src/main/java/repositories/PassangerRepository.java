package repositories;

import core.BusinessRuleValidationException;
import model.Passanger;

import java.util.UUID;

public interface PassangerRepository {

    UUID update(Passanger passanger);

    Passanger get(UUID id) throws BusinessRuleValidationException;
}
