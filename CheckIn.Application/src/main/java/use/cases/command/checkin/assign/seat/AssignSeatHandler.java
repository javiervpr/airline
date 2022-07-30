package use.cases.command.checkin.assign.seat;

import an.awesome.pipelinr.Command;
import java.util.UUID;
import model.CheckIn;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;

@Component
public class AssignSeatHandler
  implements Command.Handler<AssignSeatCommand, UUID> {

  private final CheckInRepository checkInRepository;

  public AssignSeatHandler(
    CheckInRepository checkInRepository,
    PassangerRepository passangerRepository,
    SeatRepository seatRepository
  ) {
    this.checkInRepository = checkInRepository;
  }

  @Override
  public UUID handle(AssignSeatCommand request) {
    try {
      CheckIn checkIn = checkInRepository.findByPassangerAndFlightId(
        UUID.fromString(request.checkInDto.passanger.id),
        UUID.fromString(request.checkInDto.flightId)
      );
      checkIn.assignSeat(UUID.fromString(request.checkInDto.seat.code));
      checkInRepository.update(checkIn);
      return checkIn.getId();
    } catch (Exception e) {
      return null;
    }
  }
}
