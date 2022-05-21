package event;

import core.BusinessRuleValidationException;
import model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckInCompletedTests {
    @Test
    void testCreation() throws BusinessRuleValidationException {
        Seat seat = new Seat(UUID.randomUUID(), SeatType.FIRST_CLASS, SeatStatus.FREE, UUID.randomUUID());
        Passanger passanger = new Passanger("Javier", "Roca", new Date(), "9743123",false);
        CheckIn checkIn = new CheckIn(seat.getFlightId(), List.of(seat),passanger);
        CheckInCompleted checkInCompleted = new CheckInCompleted(checkIn);
        assertEquals(checkIn, checkInCompleted.getCheckIn());
    }
}
