package factories.check.in;

import model.CheckIn;
import model.Passanger;
import model.Seat;

import java.util.List;
import java.util.UUID;

public interface CheckInFactory {

    CheckIn create(UUID flightId, List<Seat> avaibleSeats, Passanger passanger);
}
