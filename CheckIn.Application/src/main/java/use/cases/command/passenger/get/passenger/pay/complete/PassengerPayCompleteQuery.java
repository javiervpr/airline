package use.cases.command.passenger.get.passenger.pay.complete;

import an.awesome.pipelinr.Command;
import dtos.PassangerDto;
import java.util.List;

public class PassengerPayCompleteQuery implements Command<List<PassangerDto>> {

  String flightId;

  public PassengerPayCompleteQuery(String flightId) {
    this.flightId = flightId;
  }
}
