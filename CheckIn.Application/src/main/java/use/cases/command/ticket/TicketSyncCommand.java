package use.cases.command.ticket;

import an.awesome.pipelinr.Command;
import dtos.PaymentCompleteDto;

import java.util.UUID;

public class TicketSyncCommand implements Command<UUID> {

    PaymentCompleteDto paymentCompleteDto;

    public TicketSyncCommand(PaymentCompleteDto paymentCompleteDto) {
        this.paymentCompleteDto = paymentCompleteDto;
    }
}
