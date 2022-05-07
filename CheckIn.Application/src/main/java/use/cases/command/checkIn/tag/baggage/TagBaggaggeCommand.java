package use.cases.command.checkIn.tag.baggage;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;

import java.util.UUID;

public class TagBaggaggeCommand implements Command<UUID> {

    CheckInDto checkInDto;

    public TagBaggaggeCommand(CheckInDto checkInDto) {
        this.checkInDto = checkInDto;
    }
}
