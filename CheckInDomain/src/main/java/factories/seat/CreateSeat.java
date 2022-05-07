package factories.seat;

import core.BusinessRuleValidationException;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

import java.util.UUID;

public class CreateSeat implements SeatFactory{

    @Override
    public Seat create(String code, String type, String status, String flightId) throws BusinessRuleValidationException {
        return new Seat(UUID.fromString(code), SeatType.valueOf(type), SeatStatus.valueOf(status), UUID.fromString(flightId));
    }
}
