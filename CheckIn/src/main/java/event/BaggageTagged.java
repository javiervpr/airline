package event;

import core.DomainEvent;
import model.CheckIn;


public class BaggageTagged extends DomainEvent {

    private CheckIn checkIn;

    public BaggageTagged(CheckIn checkIn) {
        super(checkIn.getDate());
        this.checkIn = checkIn;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }
}
