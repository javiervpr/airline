package use.cases.command.checkin.seats;

import an.awesome.pipelinr.Command;
import dtos.SeatDto;
import java.util.List;

public class GetSeatsByFlightQuery implements Command<List<SeatDto>> {

  String flightId;

  public GetSeatsByFlightQuery(String flightId) {
    this.flightId = flightId;
  }
}
