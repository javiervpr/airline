package controllers;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import builder.BaggageDtoBuilder;
import builder.CheckInDtoBuilder;
import builder.PassangerDtoBuilder;
import builder.SeatDtoBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import dtos.BaggageDto;
import dtos.CheckInDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import java.util.List;
import java.util.UUID;
import model.BaggageType;
import model.CheckIn;
import model.SeatStatus;
import model.SeatType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import use.cases.command.checkin.assign.seat.AssignSeatCommand;

class CheckInControllerTests {

  @Mock
  Pipeline pipeline;

  @Mock
  QueueMessagingTemplate queueMessagingTemplate;

  @Mock
  AssignSeatCommand assignSeatCommand;

  private static final UUID FLIGHT_ID = UUID.randomUUID();
  private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

//  @Test
//  void testAssignSeat() throws JsonProcessingException {
//    SeatDto seatDto = new SeatDtoBuilder()
//      .withCode(SEAT_ECONOMY_FREE_CODE.toString())
//      .withType(SeatType.ECONOMY.toString())
//      .withStatus(SeatStatus.FREE.toString())
//      .build();
//    PassangerDto passangerDto = new PassangerDtoBuilder().build();
//
//    CheckInDto checkInDto = new CheckInDtoBuilder()
//      .withFlightId(FLIGHT_ID.toString())
//      .withSeat(seatDto)
//      .withPassanger(passangerDto)
//      .build();
//
//    when(pipeline.send((Command<Object>) anyObject()))
//      .thenReturn(UUID.randomUUID());
//
//    CheckInController checkInController = new CheckInController(pipeline, queueMessagingTemplate);
//    String checkIn = checkInController.assignSeat(checkInDto);
//    assertNotNull(checkIn);
//  }

  @Test
  void testTagBaggage() {
    BaggageDto baggageDto = new BaggageDtoBuilder()
      .withWeight(20)
      .withType(BaggageType.CHECKED_BAG.toString())
      .build();
    PassangerDto passangerDto = new PassangerDtoBuilder().build();

    CheckInDto checkInDto = new CheckInDtoBuilder()
      .withFlightId(FLIGHT_ID.toString())
      .withBaggages(List.of(baggageDto))
      .withPassanger(passangerDto)
      .build();

    when(pipeline.send((Command<Object>) anyObject()))
      .thenReturn(UUID.randomUUID());
    CheckInController checkInController = new CheckInController(pipeline, queueMessagingTemplate);
    UUID checkInId = checkInController.tagBaggage(checkInDto);
    assertNotNull(checkInId);
    assertNotEquals(UUID.fromString(checkInDto.checkInId), checkInId);
  }

  @Test
  void testCreateCheckIn() {
    PassangerDto passangerDto = new PassangerDtoBuilder().build();
    SeatDto seatDto = new SeatDtoBuilder()
      .withCode(SEAT_ECONOMY_FREE_CODE.toString())
      .withType(SeatType.ECONOMY.toString())
      .withStatus(SeatStatus.FREE.toString())
      .build();

    CheckInDto checkInDto = new CheckInDtoBuilder()
      .withFlightId(FLIGHT_ID.toString())
      .withAvaibleSeats(List.of(seatDto))
      .withPassanger(passangerDto)
      .build();

    when(pipeline.send((Command<Object>) anyObject()))
      .thenReturn(UUID.randomUUID());
    CheckInController checkInController = new CheckInController(pipeline, queueMessagingTemplate);
    UUID checkInId = checkInController.createCheckIn(checkInDto);
    assertNotNull(checkInId);
    assertNotEquals(UUID.fromString(checkInDto.checkInId), checkInId);
  }
}
