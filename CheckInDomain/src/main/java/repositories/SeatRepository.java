package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.Seat;

public interface SeatRepository {
  UUID update(Seat seat);

  List<Seat> findByFlightIdAndStatus(UUID flightId, String status)
    throws BusinessRuleValidationException;
}
