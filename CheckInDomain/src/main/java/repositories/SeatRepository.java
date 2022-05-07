package repositories;

import core.BusinessRuleValidationException;
import model.Seat;

import java.util.List;
import java.util.UUID;

public interface SeatRepository {

    UUID update(Seat seat);

    List<Seat> findByFlightIdAndStatus(UUID flightId, String status) throws BusinessRuleValidationException;
}
