package controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import builder.SeatDtoBuilder;
import dtos.SeatDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SeatControllerTests {

  @Mock
  Pipeline pipeline;

  private static final UUID FLIGHT_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetSeatsByFlight() {
    List<SeatDto> seatDtos = new ArrayList<>();
    seatDtos.add(new SeatDtoBuilder().build());
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(seatDtos);

    SeatController controller = new SeatController(pipeline);
    List<SeatDto> response = controller.getSeatsByFlightId(
      FLIGHT_ID.toString()
    );
    assertNotNull(response);
  }
}
