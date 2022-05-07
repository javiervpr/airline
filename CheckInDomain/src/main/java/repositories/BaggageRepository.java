package repositories;

import core.BusinessRuleValidationException;
import model.Baggage;

import java.util.List;
import java.util.UUID;

public interface BaggageRepository {

    UUID update(Baggage baggage);

    List<Baggage> findByCheckInId(UUID checkInId) throws BusinessRuleValidationException;
}
