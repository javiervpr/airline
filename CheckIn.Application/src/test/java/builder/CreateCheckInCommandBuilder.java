package builder;

import dtos.BaggageDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import java.util.Date;
import java.util.List;
import use.cases.command.checkin.create.checkin.CreateCheckInCommand;

public class CreateCheckInCommandBuilder {

  public String checkInId;
  public String flightId;
  public Date date;
  public SeatDto seat;
  public List<BaggageDto> baggages;
  public List<SeatDto> avaibleSeats;
  public PassangerDto passanger;

  public CreateCheckInCommand build() {
    return new CreateCheckInCommand(
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

  public CreateCheckInCommandBuilder withCheckInId(String checkInId) {
    this.checkInId = checkInId;
    return this;
  }

  public CreateCheckInCommandBuilder withFlightId(String flightId) {
    this.flightId = flightId;
    return this;
  }

  public CreateCheckInCommandBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public CreateCheckInCommandBuilder withSeat(SeatDto seat) {
    this.seat = seat;
    return this;
  }

  public CreateCheckInCommandBuilder withBaggages(List<BaggageDto> baggages) {
    this.baggages = baggages;
    return this;
  }

  public CreateCheckInCommandBuilder withAvaibleSeats(
    List<SeatDto> avaibleSeats
  ) {
    this.avaibleSeats = avaibleSeats;
    return this;
  }

  public CreateCheckInCommandBuilder withPassanger(PassangerDto passanger) {
    this.passanger = passanger;
    return this;
  }
}
