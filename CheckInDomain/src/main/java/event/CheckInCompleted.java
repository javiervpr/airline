package event;

import core.DomainEvent;
import model.CheckIn;

public class CheckInCompleted extends DomainEvent {

  private CheckIn checkIn;

  public CheckInCompleted(CheckIn checkIn) {
    super(checkIn.getDate());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
