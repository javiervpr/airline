package use.cases.command.ticket;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import builder.PassangerBuilder;
import dtos.Body;
import dtos.Booking;
import dtos.PassangerPaymentDto;
import dtos.PaymentCompleteDto;
import java.util.UUID;
import model.Passanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.PassangerRepository;
import repositories.TicketRepository;

public class TicketSyncHandlerTests {

  @Mock
  private PassangerRepository passangerRepository;

  @Mock
  private TicketRepository ticketRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testSync() {
    assertDoesNotThrow(() -> {
      Passanger passanger = new PassangerBuilder().build();
      when(passangerRepository.get(anyObject())).thenReturn(passanger);

      PassangerPaymentDto passangerPaymentDto = new PassangerPaymentDto();
      passangerPaymentDto.id = UUID.randomUUID().toString();

      Booking booking = new Booking();
      booking.flight = UUID.randomUUID().toString();
      booking.id = UUID.randomUUID().toString();

      Body body = new Body();
      body.passanger = passangerPaymentDto;
      body.booking = booking;

      PaymentCompleteDto paymentCompleteDto = new PaymentCompleteDto();
      paymentCompleteDto.body = body;
      paymentCompleteDto.id = UUID.randomUUID().toString();

      TicketSyncCommand command = new TicketSyncCommand(paymentCompleteDto);
      TicketSyncHandler handler = new TicketSyncHandler(
        ticketRepository,
        passangerRepository
      );
      handler.handle(command);
    });
  }
}
