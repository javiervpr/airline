package repositories;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.CheckIn;

public interface CheckInRepository {
  UUID update(CheckIn checkIn);

  CheckIn get(UUID id);

  CheckIn findByPassangerAndFlightId(UUID passenger, UUID flightId)
    throws BusinessRuleValidationException;
}
