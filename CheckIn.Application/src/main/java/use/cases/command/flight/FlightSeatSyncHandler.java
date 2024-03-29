package use.cases.command.flight;

import an.awesome.pipelinr.Command;
import annotations.Generated;
import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Seat;
import model.SeatStatus;
import model.SeatType;
import org.springframework.stereotype.Component;
import repositories.SeatRepository;

@Generated
@Component
public class FlightSeatSyncHandler
  implements Command.Handler<FlightSeatSyncCommand, UUID> {

  private final SeatRepository seatRepository;

  public FlightSeatSyncHandler(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public UUID handle(FlightSeatSyncCommand command) {
    UUID flightId = UUID.fromString(command.flightDto.data.flight.uuid);
    command.flightDto.data.flight.information.avaibleSeats
      .stream()
      .forEach(seatDto -> {
        try {
          Seat seat = new Seat(
            UUID.fromString(seatDto.code),
            SeatType.valueOf(seatDto.type),
            SeatStatus.valueOf(seatDto.status),
            flightId,
            seatDto.rowColumn
          );
          this.seatRepository.update(seat);
        } catch (BusinessRuleValidationException e) {
          e.printStackTrace();
        }
      });
    return flightId;
  }
}
