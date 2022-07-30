package factories.check.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import core.BusinessRuleValidationException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.*;
import org.junit.jupiter.api.*;

class CreateCheckInTests {

  CheckInFactory checkInFactory;

  @BeforeEach
  void setUp() {
    checkInFactory = new CreateCheckIn();
  }

  @AfterEach
  void tearDown() {
    checkInFactory = null;
  }

  @Test
  void testCreate() throws BusinessRuleValidationException {
    Seat seat = new Seat(
      UUID.randomUUID(),
      SeatType.FIRST_CLASS,
      SeatStatus.FREE,
      UUID.randomUUID()
    );
    Passanger passanger = new Passanger(
      "Javier",
      "Roca",
      new Date(),
      "9743123",
      false
    );
    CheckIn checkIn = checkInFactory.create(
      seat.getFlightId(),
      List.of(seat),
      passanger
    );
    assertEquals(seat, checkIn.getAvaibleSeats().get(0));
    assertEquals(passanger, checkIn.getPassanger());
    assertEquals(seat.getFlightId(), checkIn.getFlightId());
    assertNotNull(checkIn.id);
  }
}
