package use.cases.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.CheckInDto;
import dtos.SeatDto;
import factories.check.in.CheckInFactory;
import factories.check.in.CreateCheckIn;
import factories.seat.CreateSeat;
import factories.seat.SeatFactory;
import java.util.List;
import java.util.UUID;
import model.CheckIn;
import model.Passanger;
import model.Seat;
import model.SeatStatus;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;
import utils.CheckInMapper;

@Component
public class CreateCheckInHandler
  implements Command.Handler<CreateCheckInCommand, CheckInDto> {

  private final CheckInRepository checkInRepository;
  private final SeatRepository seatRepository;
  private final SeatFactory seatFactory;
  private final CheckInFactory checkInFactory;
  private final PassangerRepository passangerRepository;

  public CreateCheckInHandler(
    CheckInRepository checkInRepository,
    SeatRepository seatRepository,
    PassangerRepository passangerRepository
  ) {
    this.checkInRepository = checkInRepository;
    this.seatRepository = seatRepository;
    this.passangerRepository = passangerRepository;
    this.seatFactory = new CreateSeat();
    this.checkInFactory = new CreateCheckIn();
  }

  @Override
  public CheckInDto handle(CreateCheckInCommand request) {
    try {
      CheckIn checkIn = checkInRepository.findByPassangerAndFlightId(
        UUID.fromString(request.checkInDto.passanger.id),
        UUID.fromString(request.checkInDto.flightId)
      );
      if (checkIn != null) {
        return CheckInMapper.from(checkIn);
      }
      Passanger passanger =
        this.passangerRepository.get(
            UUID.fromString(request.checkInDto.passanger.id)
          );

      List<Seat> avaibleSeats = seatRepository.findByFlightId(UUID.fromString(request.checkInDto.flightId));
//              seatRepository.findByFlightIdAndStatus(
//        UUID.fromString(request.checkInDto.flightId),
//        SeatStatus.FREE.toString()
//      );
      checkIn = checkInFactory.create( UUID.fromString(request.checkInDto.flightId), avaibleSeats, passanger);
      checkInRepository.update(checkIn);
//      for (SeatDto seatDto : avaibleSeats) {
//        Seat seat = null;
//        seat =
//          seatFactory.create(
//            seatDto.code,
//            seatDto.type,
//            seatDto.status,
//            request.checkInDto.flightId
//          );
//        seatRepository.update(seat);
//      }
//      return checkIn.id;
      return CheckInMapper.from(checkIn);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
