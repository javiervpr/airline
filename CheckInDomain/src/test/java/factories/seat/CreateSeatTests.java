package factories.seat;

import core.BusinessRuleValidationException;
import factories.passanger.CreatePassanger;
import model.Passanger;
import model.Seat;
import model.SeatStatus;
import model.SeatType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateSeatTests {

    SeatFactory seatFactory;

    @BeforeEach
    void setUp() {
        seatFactory = new CreateSeat();
    }

    @AfterEach
    void tearDown() {
        seatFactory = null;
    }

    @Test
    void testCreate() throws BusinessRuleValidationException {
        String code = UUID.randomUUID().toString();
        String flightId = UUID.randomUUID().toString();
        Seat seat = seatFactory.create(code, SeatType.FIRST_CLASS.toString(), SeatStatus.FREE.toString(), flightId);
        assertEquals(SeatType.FIRST_CLASS.toString(), seat.getType().toString());
        assertEquals(SeatStatus.FREE.toString(), seat.getStatus().toString());
        assertEquals(code, seat.getCode().toString());
        assertEquals(flightId, seat.getFlightId().toString());
    }
}
