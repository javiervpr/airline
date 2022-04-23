package model;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import event.BaggageTagged;
import event.CheckInCompleted;
import event.SeatAssigned;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckIn extends AggregateRoot {


    private UUID flightId;
    private Date date;
    private Seat seat;
    private Baggage baggage;
    private List<Seat> avaibleSeats;
    private Passanger passanger;

    public CheckIn(UUID flightId, List<Seat> avaibleSeats, Passanger passanger) {
        this.flightId = flightId;
        this.avaibleSeats = avaibleSeats;
        this.passanger = passanger;
        this.date = new Date();
    }


    public void assignSeat(UUID seatId) throws BusinessRuleValidationException {
         Seat targetSeat = avaibleSeats.stream().filter(s -> s.id.equals(seatId)).findFirst().orElse(null);
         if (targetSeat == null)
             throw new BusinessRuleValidationException("This seatId is not valid" + seatId);
         if (targetSeat.getStatus().equals(SeatStatus.BOOKED)) {
             throw new BusinessRuleValidationException("This seatId is already booked" + seatId);
         }
         if (passanger.isNeedAssistance()) {
             targetSeat = this.avaibleSeats.stream()
                     .filter(s -> s.getStatus().equals(SeatStatus.FREE)
                     && s.getType().equals(SeatType.ASSISTANCE)).findFirst().orElse(null);
             if (targetSeat == null)
                 throw new BusinessRuleValidationException("There is not assistance seat available");
         }
        this.seat = targetSeat;
         addDomainEvent(new SeatAssigned(this));
         completeCheckIn();
    }


    public void tagBaggage(float weight) throws BusinessRuleValidationException {
        this.baggage = new Baggage(weight);
        addDomainEvent(new BaggageTagged(this));
        completeCheckIn();
    }

    public void completeCheckIn() {
        if (this.baggage != null && this.seat != null)
            addDomainEvent(new CheckInCompleted(this));
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

    public Baggage getBaggage() {
        return baggage;
    }

    public List<Seat> getAvaibleSeats() {
        return avaibleSeats;
    }

    public Passanger getPassanger() {
        return passanger;
    }
}
