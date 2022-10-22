package use.cases.command.flight;

import an.awesome.pipelinr.Command;
import annotations.Generated;
import dtos.FlightDto;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Generated
public class FlightSeatSyncCommand implements Command<UUID> {

  FlightDto flightDto;

  public FlightSeatSyncCommand(FlightDto flightDto) {
    this.flightDto = flightDto;
  }
}
