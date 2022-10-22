package use.cases.command.checkin.seats;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.SeatBuilder;
import dtos.SeatDto;
import java.util.ArrayList;
import java.util.List;
import model.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.SeatRepository;

public class GetSeatsByFlightHandlerTests {

  @Mock
  private SeatRepository seatRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetSeatsByFlightId() {
    assertDoesNotThrow(() -> {
      List<Seat> seats = new ArrayList<>();
      seats.add(new SeatBuilder().build());
      when(seatRepository.findByFlightId(anyObject())).thenReturn(seats);

      GetSeatsByFlightQuery query = new GetSeatsByFlightQuery(
        seats.get(0).getFlightId().toString()
      );

      GetSeatsByFlightHandler handler = new GetSeatsByFlightHandler(
        seatRepository
      );
      List<SeatDto> seatDtos = handler.handle(query);
      assertNotNull(seatDtos);
      assertEquals(seats.get(0).getCode().toString(), seatDtos.get(0).code);
    });
  }
}
