package use.cases.command.checkin.assign.seat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.AssignSeatCommandBuilder;
import builder.CheckInBuilder;
import builder.PassangerBuilder;
import builder.SeatBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import dtos.SeatDto;
import java.util.List;
import java.util.UUID;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;
import utils.PassangerMapper;
import utils.SeatMapper;

class AssignSeatHandlerTests {

  @Mock
  CheckInRepository checkInRepository;

  @Mock
  AmazonSNS amazonSNSAsync;

  @Mock
  SeatRepository seatRepository;

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testAssignSeatHandler() {
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

      AssignSeatCommand request = new AssignSeatCommandBuilder()
        .withFlightId(FLIGHT_ID.toString())
        .withSeat(SeatMapper.from(seatEconomyFree))
        .withPassanger(PassangerMapper.from(passanger))
        .build();

      AssignSeatHandler assignSeatHandler = new AssignSeatHandler(
        checkInRepository,
        seatRepository,
        amazonSNSAsync
      );
      when(
        checkInRepository.findByPassangerAndFlightId(anyObject(), anyObject())
      )
        .thenReturn(checkIn);

      SeatDto seatDto = assignSeatHandler.handle(request);
      assertNotNull(seatDto);
    });
  }
}
