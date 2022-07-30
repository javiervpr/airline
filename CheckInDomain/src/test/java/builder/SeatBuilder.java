package builder;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

public class SeatBuilder {

  private UUID code = UUID.randomUUID();
  private SeatType type = SeatType.ECONOMY;
  private SeatStatus status = SeatStatus.FREE;
  private UUID flightId = UUID.randomUUID();

  public Seat build() throws BusinessRuleValidationException {
    return new Seat(code, type, status, flightId);
  }

  public SeatBuilder withCode(UUID code) {
    this.code = code;
    return this;
  }

  public SeatBuilder withType(SeatType type) {
    this.type = type;
    return this;
  }

  public SeatBuilder withStatus(SeatStatus status) {
    this.status = status;
    return this;
  }

  public SeatBuilder withFlightId(UUID flightId) {
    this.flightId = flightId;
    return this;
  }
}
