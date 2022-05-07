package use.cases.command.checkIn.create.checkin;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;

import java.util.UUID;

public class CreateCheckInCommand implements Command<UUID>  {
    CheckInDto checkInDto;

    public CreateCheckInCommand(CheckInDto checkInDto) {
        this.checkInDto = checkInDto;
    }
}
