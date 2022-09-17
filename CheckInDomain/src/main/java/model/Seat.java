package model;

import core.BusinessRuleValidationException;
import core.Entity;
import java.util.UUID;

public class Seat extends Entity {

  private UUID code;
  private SeatType type;
  private SeatStatus status;
  private UUID flightId;

  public Seat(UUID code, SeatType type, SeatStatus status, UUID flightId)
    throws BusinessRuleValidationException {
    this.code = code;
    this.type = type;
    this.status = status;
    this.flightId = flightId;
  }

  public void updateStatus(SeatStatus status) {
    this.status = status;
  }

  public UUID getCode() {
    return code;
  }

  public SeatType getType() {
    return type;
  }

  public SeatStatus getStatus() {
    return status;
  }

  public UUID getFlightId() {
    return flightId;
  }
}
