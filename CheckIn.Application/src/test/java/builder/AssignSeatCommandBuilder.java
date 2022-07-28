package builder;

import dtos.CheckInDto;
import use.cases.command.checkIn.assign.seat.AssignSeatCommand;

public class AssignSeatCommandBuilder {

    private CheckInDto checkInDto = new CheckInDtoBuilder().build();

    public AssignSeatCommand build() {
        return new AssignSeatCommand(checkInDto);
    }
}
