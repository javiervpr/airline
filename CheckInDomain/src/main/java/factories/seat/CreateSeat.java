package factories.seat;

import core.BusinessRuleValidationException;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

public class CreateSeat implements SeatFactory{
    @Override
    public Seat create(String code, String type, String status) throws BusinessRuleValidationException {
        return new Seat(code, SeatType.valueOf(type), SeatStatus.valueOf(status));
    }
}
