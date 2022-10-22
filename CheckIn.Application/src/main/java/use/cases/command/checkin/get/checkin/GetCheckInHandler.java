package use.cases.command.checkin.get.checkin;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.CheckInDto;
import java.util.UUID;
import model.CheckIn;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import utils.CheckInMapper;

@Component
public class GetCheckInHandler
  implements Command.Handler<GetCheckInQuery, CheckInDto> {

  private final CheckInRepository checkInRepository;

  public GetCheckInHandler(CheckInRepository checkInRepository) {
    this.checkInRepository = checkInRepository;
  }

  @Override
  public CheckInDto handle(GetCheckInQuery query) {
    CheckIn checkIn = null;
    try {
      checkIn =
        this.checkInRepository.findByPassangerAndFlightId(
            UUID.fromString(query.passengerId),
            UUID.fromString(query.flightId)
          );
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
    }
    return CheckInMapper.from(checkIn);
  }
}
