package use.cases.command.ticket;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PaymentCompleteDto;
import model.Passanger;
import model.Ticket;
import org.springframework.stereotype.Component;
import repositories.PassangerRepository;
import repositories.TicketRepository;

import java.util.UUID;

@Component
public class TicketSyncHandler implements Command.Handler<TicketSyncCommand, UUID> {

    private final TicketRepository ticketRepository;
    private final PassangerRepository passangerRepository;

    public TicketSyncHandler(TicketRepository ticketRepository, PassangerRepository passangerRepository) {
        this.ticketRepository = ticketRepository;
        this.passangerRepository = passangerRepository;
    }

    @Override
    public UUID handle(TicketSyncCommand command) {
        PaymentCompleteDto paymentCompleteDto = command.paymentCompleteDto;
        try {
            Passanger passanger = passangerRepository.get(UUID.fromString(paymentCompleteDto.body.passanger.id));
            return this.ticketRepository.update( new Ticket(
                    passanger,
                    UUID.fromString(paymentCompleteDto.body.booking.flight),
                    UUID.fromString(paymentCompleteDto.body.booking.id))
            );
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
