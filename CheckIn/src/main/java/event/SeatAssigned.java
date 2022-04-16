package event;

import core.DomainEvent;
import model.CheckIn;


public class SeatAssigned extends DomainEvent {

    private CheckIn checkIn;


    public SeatAssigned(CheckIn checkIn) {
        super(checkIn.getDate());
        this.checkIn = checkIn;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }
}
