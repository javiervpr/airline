package factories.seat;

import core.BusinessRuleValidationException;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

public interface SeatFactory {

    Seat create(String code, String type, String status, String flightId) throws BusinessRuleValidationException;
}
