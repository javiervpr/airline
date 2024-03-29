package model;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import event.BaggageTagged;
import event.CheckInCompleted;
import event.SeatAssigned;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckIn extends AggregateRoot {

  private UUID flightId;
  private Date date;
  private Seat seat;
  private Seat oldSeat;
  private List<Baggage> baggages;
  private List<Seat> avaibleSeats;
  private Passanger passanger;

  public CheckIn(UUID flightId, List<Seat> avaibleSeats, Passanger passanger) {
    this.flightId = flightId;
    this.avaibleSeats = avaibleSeats;
    this.passanger = passanger;
    this.date = new Date();
    this.baggages = new ArrayList<>();
  }

  public CheckIn(
    UUID id,
    UUID flightId,
    List<Seat> avaibleSeats,
    Passanger passanger,
    Seat seat,
    List<Baggage> baggages
  ) {
    this.id = id;
    this.flightId = flightId;
    this.avaibleSeats = avaibleSeats;
    this.passanger = passanger;
    this.date = new Date();
    this.seat = seat;
    this.baggages = baggages;
  }

  public void assignSeat(UUID seatCode) throws BusinessRuleValidationException {
    Seat targetSeat = avaibleSeats
      .stream()
      .filter(s -> s.getCode().equals(seatCode))
      .findFirst()
      .orElse(null);
    if (targetSeat == null) throw new BusinessRuleValidationException(
      "This seatCode is not valid" + seatCode
    );
    if (targetSeat.getStatus().equals(SeatStatus.BOOKED)) {
      throw new BusinessRuleValidationException(
        "This seatCode is already booked" + seatCode
      );
    }
    if (
      targetSeat.getType() == SeatType.ASSISTANCE &&
      !passanger.isNeedAssistance()
    ) {
      throw new BusinessRuleValidationException(
        "This is special seat for assistance"
      );
    }
    if (this.seat != null) {
      this.oldSeat = this.seat;
      this.oldSeat.updateStatus(SeatStatus.FREE);
    }
    targetSeat.updateStatus(SeatStatus.BOOKED);
    this.seat = targetSeat;
    addDomainEvent(new SeatAssigned(this));
    completeCheckIn();
  }

  public void tagBaggage(float weight) throws BusinessRuleValidationException {
    this.baggages.add(new Baggage(weight, this.id));
    addDomainEvent(new BaggageTagged(this));
    completeCheckIn();
  }

  public void completeCheckIn() {
    if (this.baggages != null && this.seat != null) addDomainEvent(
      new CheckInCompleted(this)
    );
  }

  public UUID getFlightId() {
    return flightId;
  }

  public Date getDate() {
    return date;
  }

  public Seat getSeat() {
    return seat;
  }

  public List<Baggage> getBaggages() {
    return baggages;
  }

  public List<Seat> getAvaibleSeats() {
    return avaibleSeats;
  }

  public Passanger getPassanger() {
    return passanger;
  }

  public Seat getOldSeat() {
    return oldSeat;
  }
}
