package use.cases.command.passenger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import dtos.PassengerBodySync;
import dtos.PassengerObjectSync;
import dtos.PassengerSyncDto;
import java.util.UUID;
import model.Passanger;
import model.PassangerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.PassangerRepository;

public class PassengerSyncHandlerTests {

  @Mock
  private PassangerRepository passangerRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testSyncPassenger() {
    assertDoesNotThrow(() -> {
      UUID passengerId = UUID.randomUUID();
      when(passangerRepository.update(anyObject())).thenReturn(passengerId);
      PassengerObjectSync passengerObjectSync = new PassengerObjectSync();
      passengerObjectSync.id = passengerId.toString();
      passengerObjectSync.name = "Juan";
      passengerObjectSync.lastName = "Pereira";
      passengerObjectSync.passport = "12333";
      passengerObjectSync.needsAssistance = false;

      PassengerBodySync bodySync = new PassengerBodySync();
      bodySync.passanger = passengerObjectSync;

      PassengerSyncDto passengerSyncDto = new PassengerSyncDto();
      passengerSyncDto.id = passengerId.toString();
      passengerSyncDto.body = bodySync;

      PassengerSyncCommand command = new PassengerSyncCommand(passengerSyncDto);
      PassengerSyncHandler handler = new PassengerSyncHandler(
        passangerRepository
      );
      UUID response = handler.handle(command);
      assertNotNull(response);
      assertEquals(passengerId, response);
    });
  }
}
