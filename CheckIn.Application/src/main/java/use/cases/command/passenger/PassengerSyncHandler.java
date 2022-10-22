package use.cases.command.passenger;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PassengerObjectSync;
import dtos.PassengerSyncDto;
import model.Passanger;
import org.springframework.stereotype.Component;
import repositories.PassangerRepository;

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
        PassengerObjectSync dto = command.passengerSyncDto.body.passanger;
        UUID passengerId = UUID.fromString(dto.id);
        try {
            Passanger passanger = new Passanger(passengerId,dto.name, dto.lastName, new Date(), dto.passport,dto.needsAssistance);
            passangerRepository.update(passanger);
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
        }
        return passengerId;
    }
}
