package use.cases.command.passenger;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PassengerSyncDto;
import model.Passanger;
import org.springframework.stereotype.Component;
import repositories.PassangerRepository;
import use.cases.command.flight.FlightSeatSyncCommand;
import utils.PassangerMapper;

import java.util.Date;
import java.util.UUID;

@Component
public class PassengerSyncHandler implements Command.Handler<PassengerSyncCommand, UUID> {

    private final PassangerRepository passangerRepository;

    public PassengerSyncHandler(PassangerRepository passangerRepository) {
        this.passangerRepository = passangerRepository;
    }

    @Override
    public UUID handle(PassengerSyncCommand command) {
        PassengerSyncDto dto = command.passengerSyncDto;
        UUID passengerId = UUID.fromString(dto.id);
        try {
            Passanger passanger = new Passanger(passengerId,dto.name, dto.lastname, new Date(), dto.passport,dto.needAssistance);
            passangerRepository.update(passanger);
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
        }
        return passengerId;
    }
}