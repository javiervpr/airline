package builder;

import dtos.BaggageDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import java.util.Date;
import java.util.List;
import use.cases.command.checkin.assign.seat.AssignSeatCommand;

public class AssignSeatCommandBuilder {

  private String checkInId;
  private String flightId;
  private Date date;
  private SeatDto seat;
  private List<BaggageDto> baggages;
  private List<SeatDto> avaibleSeats;
  private PassangerDto passanger;

  public AssignSeatCommand build() {
    return new AssignSeatCommand(
      new CheckInDtoBuilder()
        .withCheckInId(checkInId)
        .withFlightId(flightId)
        .withDate(date)
        .withSeat(seat)
        .withBaggages(baggages)
        .withAvaibleSeats(avaibleSeats)
        .withPassanger(passanger)
        .build()
    );
  }

  public AssignSeatCommandBuilder withCheckInId(String checkInId) {
    this.checkInId = checkInId;
    return this;
  }

  public AssignSeatCommandBuilder withFlightId(String flightId) {
    this.flightId = flightId;
    return this;
  }

  public AssignSeatCommandBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public AssignSeatCommandBuilder withSeat(SeatDto seat) {
    this.seat = seat;
    return this;
  }

  public AssignSeatCommandBuilder withBaggages(List<BaggageDto> baggages) {
    this.baggages = baggages;
    return this;
  }

  public AssignSeatCommandBuilder withAvaibleSeats(List<SeatDto> avaibleSeats) {
    this.avaibleSeats = avaibleSeats;
    return this;
  }

  public AssignSeatCommandBuilder withPassanger(PassangerDto passanger) {
    this.passanger = passanger;
    return this;
  }
}
