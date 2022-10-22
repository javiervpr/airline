package use.cases.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;
import java.util.UUID;

public class CreateCheckInCommand implements Command<CheckInDto> {

  CheckInDto checkInDto;

  public CreateCheckInCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
