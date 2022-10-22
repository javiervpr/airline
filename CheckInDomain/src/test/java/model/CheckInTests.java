package model;

import static org.junit.jupiter.api.Assertions.*;

import builder.CheckInBuilder;
import builder.PassangerBuilder;
import builder.SeatBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CheckInTests {

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

  @Test
  void testAssignSeat() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      Seat seatEconomyFree = new SeatBuilder()
        .withFlightId(FLIGHT_ID)
        .withCode(SEAT_ECONOMY_FREE_CODE)
        .withType(SeatType.ECONOMY)
        .withStatus(SeatStatus.FREE)
        .build();

      CheckIn checkIn = new CheckInBuilder()
        .withFlightId(FLIGHT_ID)
        .withPassanger(passanger)
        .withAvaibleSeats(List.of(seatEconomyFree))
        .build();

      checkIn.assignSeat(SEAT_ECONOMY_FREE_CODE);
      assertEquals(SEAT_ECONOMY_FREE_CODE, checkIn.getSeat().getCode());
    });
  }

  @Test
  void testTagBaggage() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      Seat seatEconomyFree = new SeatBuilder()
        .withFlightId(FLIGHT_ID)
        .withCode(SEAT_ECONOMY_FREE_CODE)
        .withType(SeatType.ECONOMY)
        .withStatus(SeatStatus.FREE)
        .build();

      CheckIn checkIn = new CheckInBuilder()
        .withFlightId(FLIGHT_ID)
        .withPassanger(passanger)
        .withAvaibleSeats(List.of(seatEconomyFree))
        .build();

      checkIn.tagBaggage(20);
      assertTrue(checkIn.getBaggages().size() > 0);
    });
  }

  @Test
  void testCreateCheckIn() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      Seat seatEconomyFree = new SeatBuilder()
        .withFlightId(FLIGHT_ID)
        .withCode(SEAT_ECONOMY_FREE_CODE)
        .withType(SeatType.ECONOMY)
        .withStatus(SeatStatus.FREE)
        .build();
      UUID checkInId = UUID.randomUUID();
      CheckIn checkIn =
      new CheckIn(checkInId, FLIGHT_ID, List.of(seatEconomyFree), passanger, seatEconomyFree, new ArrayList<>());
      assertNotNull(checkIn);
      assertEquals(checkInId, checkIn.getId());
    });
  }
}
