package use.cases.command.passenger.get.passengers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import builder.PassangerBuilder;
import dtos.PassangerDto;
import java.util.ArrayList;
import java.util.List;
import model.Passanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.PassangerRepository;

public class GetPassengersHandlerTests {

  @Mock
  private PassangerRepository passangerRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetPassengers() {
    assertDoesNotThrow(() -> {
      List<Passanger> passangers = new ArrayList<>();
      passangers.add(new PassangerBuilder().build());
      when(passangerRepository.getAll()).thenReturn(passangers);

      GetPassengersQuery query = new GetPassengersQuery();
      GetPassengersHandler handler = new GetPassengersHandler(
        passangerRepository
      );
      List<PassangerDto> dtos = handler.handle(query);

      assertNotNull(dtos);
      assertEquals(passangers.get(0).getId().toString(), dtos.get(0).id);
    });
  }
}
