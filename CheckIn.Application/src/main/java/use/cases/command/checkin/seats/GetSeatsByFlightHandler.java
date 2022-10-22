package use.cases.command.checkin.seats;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.SeatDto;
import java.util.List;
import java.util.UUID;
import model.Seat;
import org.springframework.stereotype.Component;
import repositories.SeatRepository;
import utils.SeatMapper;

@Component
public class GetSeatsByFlightHandler
  implements Command.Handler<GetSeatsByFlightQuery, List<SeatDto>> {

  private final SeatRepository seatRepository;

  public GetSeatsByFlightHandler(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public List<SeatDto> handle(GetSeatsByFlightQuery command) {
    try {
      List<Seat> seats = seatRepository.findByFlightId(
        UUID.fromString(command.flightId)
      );
      return seats.stream().map(SeatMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
