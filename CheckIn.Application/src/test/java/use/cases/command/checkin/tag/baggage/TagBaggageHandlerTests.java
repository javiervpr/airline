package use.cases.command.checkin.tag.baggage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.*;
import java.util.List;
import java.util.UUID;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.BaggageRepository;
import repositories.CheckInRepository;
import utils.BaggageMapper;
import utils.PassangerMapper;

class TagBaggageHandlerTests {

  @Mock
  CheckInRepository checkInRepository;

  @Mock
  BaggageRepository baggageRepository;

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testTagBaggageHandlerTest() {
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

      Baggage baggage = new BaggageBuilder()
        .withCheckInId(checkIn.id)
        .withWeight(20)
        .build();

      TagBaggaggeCommand request = new TagBaggageCommandBuilder()
        .withFlightId(FLIGHT_ID.toString())
        .withBaggages(List.of(BaggageMapper.from(baggage)))
        .withPassanger(PassangerMapper.from(passanger))
        .build();

      TagBaggageHandler handler = new TagBaggageHandler(
        checkInRepository,
        baggageRepository
      );
      when(
        checkInRepository.findByPassangerAndFlightId(anyObject(), anyObject())
      )
        .thenReturn(checkIn);

      UUID checkInId = handler.handle(request);
      assertNotNull(checkInId);
    });
  }
}
