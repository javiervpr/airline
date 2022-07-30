package use.cases.command.checkin.tag.baggage;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.BaggageDto;
import java.util.UUID;
import model.Baggage;
import model.CheckIn;
import org.springframework.stereotype.Component;
import repositories.BaggageRepository;
import repositories.CheckInRepository;

@Component
public class TagBaggageHandler
  implements Command.Handler<TagBaggaggeCommand, UUID> {

  private final CheckInRepository checkInRepository;
  private final BaggageRepository baggageRepository;

  public TagBaggageHandler(
    CheckInRepository checkInRepository,
    BaggageRepository baggageRepository
  ) {
    this.checkInRepository = checkInRepository;
    this.baggageRepository = baggageRepository;
  }

  @Override
  public UUID handle(TagBaggaggeCommand request) {
    try {
      CheckIn checkIn;
      checkIn =
        checkInRepository.findByPassangerAndFlightId(
          UUID.fromString(request.checkInDto.passanger.id),
          UUID.fromString(request.checkInDto.flightId)
        );

      for (BaggageDto baggageDto : request.checkInDto.baggages) {
        baggageRepository.update(new Baggage(baggageDto.weight, checkIn.id));
      }
      return checkIn.getId();
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
