package builder;

import dtos.BaggageDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import java.util.Date;
import java.util.List;
import use.cases.command.checkin.tag.baggage.TagBaggaggeCommand;

public class TagBaggageCommandBuilder {

  private String checkInId;
  private String flightId;
  private Date date;
  private SeatDto seat;
  private List<BaggageDto> baggages;
  private List<SeatDto> avaibleSeats;
  private PassangerDto passanger;

  public TagBaggaggeCommand build() {
    return new TagBaggaggeCommand(
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

  public TagBaggageCommandBuilder withCheckInId(String checkInId) {
    this.checkInId = checkInId;
    return this;
  }

  public TagBaggageCommandBuilder withFlightId(String flightId) {
    this.flightId = flightId;
    return this;
  }

  public TagBaggageCommandBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public TagBaggageCommandBuilder withSeat(SeatDto seat) {
    this.seat = seat;
    return this;
  }

  public TagBaggageCommandBuilder withBaggages(List<BaggageDto> baggages) {
    this.baggages = baggages;
    return this;
  }

  public TagBaggageCommandBuilder withAvaibleSeats(List<SeatDto> avaibleSeats) {
    this.avaibleSeats = avaibleSeats;
    return this;
  }

  public TagBaggageCommandBuilder withPassanger(PassangerDto passanger) {
    this.passanger = passanger;
    return this;
  }
}
