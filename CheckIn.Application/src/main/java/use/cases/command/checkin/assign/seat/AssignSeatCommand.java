package use.cases.command.checkin.assign.seat;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;
import java.util.UUID;

public class AssignSeatCommand implements Command<UUID> {

  CheckInDto checkInDto;

  public AssignSeatCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
