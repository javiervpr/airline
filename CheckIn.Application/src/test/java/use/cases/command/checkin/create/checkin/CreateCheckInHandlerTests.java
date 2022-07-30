package use.cases.command.checkin.create.checkin;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.CreateCheckInCommandBuilder;
import builder.PassangerBuilder;
import builder.SeatBuilder;
import java.util.List;
import java.util.UUID;
import model.Passanger;
import model.Seat;
import model.SeatStatus;
import model.SeatType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;
import utils.PassangerMapper;
import utils.SeatMapper;

class CreateCheckInHandlerTests {

  @Mock
  private CheckInRepository checkInRepository;

  @Mock
  private SeatRepository seatRepository;

  @Mock
  private PassangerRepository passangerRepository;

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
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

      CreateCheckInCommand request = new CreateCheckInCommandBuilder()
        .withFlightId(FLIGHT_ID.toString())
        .withPassanger(PassangerMapper.from(passanger))
        .withAvaibleSeats(List.of(SeatMapper.from(seatEconomyFree)))
        .build();

      when(
        checkInRepository.findByPassangerAndFlightId(anyObject(), anyObject())
      )
        .thenReturn(null);

      when(passangerRepository.get(anyObject())).thenReturn(passanger);
      when(seatRepository.findByFlightIdAndStatus(anyObject(), anyObject()))
        .thenReturn(List.of(seatEconomyFree));

      CreateCheckInHandler handler = new CreateCheckInHandler(
        checkInRepository,
        seatRepository,
        passangerRepository
      );
      UUID checkInId = handler.handle(request);
      assertNotNull(checkInId);
    });
  }
}
