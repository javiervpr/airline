package use.cases.command.passenger.get.passengers;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PassangerDto;
import model.Passanger;
import org.springframework.stereotype.Component;
import repositories.PassangerRepository;
import utils.PassangerMapper;

import java.util.List;

@Component
public class GetPassengersHandler implements Command.Handler<GetPassengersQuery, List<PassangerDto>>{

    private final PassangerRepository passangerRepository;

    public GetPassengersHandler(PassangerRepository passangerRepository) {
        this.passangerRepository = passangerRepository;
    }

    @Override
    public List<PassangerDto> handle(GetPassengersQuery command) {
        try {
            List<Passanger> passangers = this.passangerRepository.getAll();
            return passangers
                    .stream()
                    .map(PassangerMapper::from)
                    .toList();
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
