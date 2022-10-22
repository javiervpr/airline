package use.cases.command.flight;

import an.awesome.pipelinr.Command;
import dtos.FlightDto;
import java.util.UUID;
import org.springframework.stereotype.Component;

public class FlightSeatSyncCommand implements Command<UUID> {

  FlightDto flightDto;

  public FlightSeatSyncCommand(FlightDto flightDto) {
    this.flightDto = flightDto;
  }
}
