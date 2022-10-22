package use.cases.command.checkin.get.checkin;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.CheckInBuilder;
import dtos.CheckInDto;
import model.CheckIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.CheckInRepository;

public class GetCheckInHandlerTests {

  @Mock
  private CheckInRepository checkInRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetCheckIn() {
    assertDoesNotThrow(() -> {
      CheckIn checkIn = new CheckInBuilder().build();
      when(this.checkInRepository.get(anyObject())).thenReturn(checkIn);

      GetCheckInQuery query = new GetCheckInQuery(
        checkIn.getFlightId().toString(),
        checkIn.getPassanger().getId().toString()
      );

      GetCheckInHandler handler = new GetCheckInHandler(checkInRepository);
      CheckInDto checkInDto = handler.handle(query);
      assertNotNull(checkInDto);
    });
  }
}
