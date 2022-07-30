package builder;

import core.BusinessRuleValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.Baggage;
import model.CheckIn;
import model.Passanger;
import model.Seat;

public class CheckInBuilder {

  public UUID flightId;
  public List<Seat> avaibleSeats;
  public Passanger passanger;

  public CheckInBuilder() throws BusinessRuleValidationException {
    this.flightId = UUID.randomUUID();
    this.avaibleSeats = new ArrayList<>();
    this.passanger = new PassangerBuilder().build();
  }

  public CheckIn build() throws BusinessRuleValidationException {
    if (avaibleSeats.size() == 0) {
      Seat seat = new SeatBuilder().withFlightId(this.flightId).build();
      this.avaibleSeats.add(seat);
    }
    return new CheckIn(flightId, avaibleSeats, passanger);
  }

  public CheckInBuilder withFlightId(UUID flightId) {
    this.flightId = flightId;
    return this;
  }

  public CheckInBuilder withAvaibleSeats(List<Seat> avaibleSeats) {
    this.avaibleSeats = avaibleSeats;
    return this;
  }

  public CheckInBuilder withPassanger(Passanger passanger) {
    this.passanger = passanger;
    return this;
  }
}
