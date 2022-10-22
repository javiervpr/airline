package use.cases.command.passenger.get.passengers;

import an.awesome.pipelinr.Command;
import dtos.PassangerDto;
import java.util.List;

public class GetPassengersQuery implements Command<List<PassangerDto>> {

  public GetPassengersQuery() {}
}
