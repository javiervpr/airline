package use.cases.command.checkIn.assign.seat;

import dtos.CheckInDto;

public class AssignSeatCommand {

    CheckInDto checkInDto;

    public AssignSeatCommand(CheckInDto checkInDto) {
        this.checkInDto = checkInDto;
    }
}
