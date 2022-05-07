package repositories;

import core.BusinessRuleValidationException;
import model.CheckIn;

import java.util.UUID;

public interface CheckInRepository {
    UUID update(CheckIn checkIn);

    CheckIn get(UUID id);

    CheckIn findByPassangerAndFlightId(UUID passenger, UUID flightId) throws BusinessRuleValidationException;
}
