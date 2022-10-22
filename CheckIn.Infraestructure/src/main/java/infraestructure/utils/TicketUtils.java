package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.TicketJpaModel;
import model.Ticket;

@Generated
public class TicketUtils {

    public static TicketJpaModel ticketToJpaEntity(Ticket ticket) {
        if (ticket == null) return null;
        TicketJpaModel ticketJpaModel = new TicketJpaModel();
        ticketJpaModel.setFlightId(ticket.getFlightId());
        ticketJpaModel.setBookingId(ticket.getBookingId());
        ticketJpaModel.setPassenger(PassangerUtils.passangerToJpaEntity(ticket.getPassanger()));
        ticketJpaModel.setId(ticket.getId());
        return ticketJpaModel;
    }

    public static Ticket jpaModelToTicket(TicketJpaModel ticketJpaModel) throws BusinessRuleValidationException {
        return new Ticket(
                ticketJpaModel.getId(),
                PassangerUtils.jpaModelToPassanger(ticketJpaModel.getPassenger()),
                ticketJpaModel.getFlightId(),
                ticketJpaModel.getBookingId()
        );
    }
}
