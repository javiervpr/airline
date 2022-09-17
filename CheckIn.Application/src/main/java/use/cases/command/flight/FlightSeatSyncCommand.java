package use.cases.command.flight;

import an.awesome.pipelinr.Command;
import dtos.FlightDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class FlightSeatSyncCommand implements Command<UUID>  {

    FlightDto flightDto;

    public FlightSeatSyncCommand(FlightDto flightDto) {
        this.flightDto = flightDto;
    }
}