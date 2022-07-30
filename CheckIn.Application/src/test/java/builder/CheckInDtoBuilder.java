package builder;

import dtos.BaggageDto;
import dtos.CheckInDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.CheckIn;

public class CheckInDtoBuilder {

  private String checkInId = UUID.randomUUID().toString();
  private String flightId = UUID.randomUUID().toString();
  private Date date = new Date();
  private List<BaggageDto> baggages = new ArrayList<>();
  private List<SeatDto> avaibleSeats = new ArrayList<>();
  private SeatDto seat;
  private PassangerDto passanger = new PassangerDto(
    UUID.randomUUID().toString(),
    "Javier",
    "Suarez",
    new Date(),
    "123DA",
    false
  );

  public CheckInDto build() {
    return new CheckInDto(
      checkInId,
      flightId,
      date,
      seat,
      baggages,
      avaibleSeats,
      passanger
    );
  }

  public CheckInDtoBuilder withCheckInId(String checkInId) {
    this.checkInId = checkInId;
    return this;
  }

  public CheckInDtoBuilder withFlightId(String flightId) {
    this.flightId = flightId;
    return this;
  }

  public CheckInDtoBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public CheckInDtoBuilder withBaggages(List<BaggageDto> baggages) {
    this.baggages = baggages;
    return this;
  }

  public CheckInDtoBuilder withAvaibleSeats(List<SeatDto> avaibleSeats) {
    this.avaibleSeats = avaibleSeats;
    return this;
  }

  public CheckInDtoBuilder withSeat(SeatDto seat) {
    this.seat = seat;
    return this;
  }

  public CheckInDtoBuilder withPassanger(PassangerDto passanger) {
    this.passanger = passanger;
    return this;
  }
}
