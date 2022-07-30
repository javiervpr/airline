package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.Baggage;

public interface BaggageRepository {
  UUID update(Baggage baggage);

  List<Baggage> findByCheckInId(UUID checkInId)
    throws BusinessRuleValidationException;
}
