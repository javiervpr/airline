package use.cases.command.passenger.get.passenger.pay.complete;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PassangerDto;
import model.Ticket;
import org.springframework.stereotype.Component;
import repositories.TicketRepository;
import utils.PassangerMapper;

import java.util.List;
import java.util.UUID;

@Component
public class PassengerPayCompleteHandler implements Command.Handler<PassengerPayCompleteQuery, List<PassangerDto>> {

    private final TicketRepository ticketRepository;

    public PassengerPayCompleteHandler(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<PassangerDto> handle(PassengerPayCompleteQuery command) {
        try {
            List<Ticket> tickets = this.ticketRepository.getByFlightId(UUID.fromString(command.flightId));
            return tickets
                    .stream()
                    .map(ticket -> PassangerMapper.from(ticket.getPassanger()))
                    .toList();
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
