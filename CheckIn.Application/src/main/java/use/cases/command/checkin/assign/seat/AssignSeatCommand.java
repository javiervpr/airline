package use.cases.command.checkin.assign.seat;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;
import dtos.SeatDto;
import java.util.UUID;
import model.CheckIn;

public class AssignSeatCommand implements Command<SeatDto> {

  CheckInDto checkInDto;

  public AssignSeatCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
