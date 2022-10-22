package controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import builder.PassangerDtoBuilder;
import dtos.PassangerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PassengerControllerTests {

  @Mock
  Pipeline pipeline;

  private static final UUID FLIGHT_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testPassengers() {
    List<PassangerDto> dtos = new ArrayList<>();
    dtos.add(new PassangerDtoBuilder().build());
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(dtos);

    PassengerController controller = new PassengerController(pipeline);
    List<PassangerDto> response = controller.getPassengers();

    assertNotNull(response);
  }

  @Test
  void testPassengersPayComplete() {
    List<PassangerDto> dtos = new ArrayList<>();
    dtos.add(new PassangerDtoBuilder().build());
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(dtos);

    PassengerController controller = new PassengerController(pipeline);
    List<PassangerDto> response = controller.getPassengersPayCompleted(
      FLIGHT_ID.toString()
    );

    assertNotNull(response);
  }
}
