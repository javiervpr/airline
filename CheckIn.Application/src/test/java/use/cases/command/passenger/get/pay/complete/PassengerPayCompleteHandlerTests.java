package use.cases.command.passenger.get.pay.complete;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.TicketBuilder;
import dtos.PassangerDto;
import java.util.ArrayList;
import java.util.List;
import model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.TicketRepository;
import use.cases.command.passenger.get.passenger.pay.complete.PassengerPayCompleteHandler;
import use.cases.command.passenger.get.passenger.pay.complete.PassengerPayCompleteQuery;

public class PassengerPayCompleteHandlerTests {

  @Mock
  private TicketRepository ticketRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetPassengersPayComplete() {
    assertDoesNotThrow(() -> {
      List<Ticket> tickets = new ArrayList<>();
      tickets.add(new TicketBuilder().build());
      when(ticketRepository.getByFlightId(anyObject())).thenReturn(tickets);

      PassengerPayCompleteQuery query = new PassengerPayCompleteQuery(
        tickets.get(0).getFlightId().toString()
      );
      PassengerPayCompleteHandler handler = new PassengerPayCompleteHandler(
        ticketRepository
      );
      List<PassangerDto> dtos = handler.handle(query);

      assertNotNull(dtos);
      assertEquals(
        tickets.get(0).getPassanger().getId().toString(),
        dtos.get(0).id
      );
    });
  }
}
