package factories.check.in;

import java.util.List;
import java.util.UUID;
import model.CheckIn;
import model.Passanger;
import model.Seat;

public class CreateCheckIn implements CheckInFactory {

  @Override
  public CheckIn create(
    UUID flightId,
    List<Seat> avaibleSeats,
    Passanger passanger
  ) {
    return new CheckIn(flightId, avaibleSeats, passanger);
  }
}
