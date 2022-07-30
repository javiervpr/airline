package dtos;

import java.util.Date;
import java.util.List;

public class CheckInDto {

  public String checkInId;
  public String flightId;
  public Date date;
  public SeatDto seat;
  public List<BaggageDto> baggages;
  public List<SeatDto> avaibleSeats;
  public PassangerDto passanger;

  public CheckInDto() {}

  public CheckInDto(
    String checkInId,
    String flightId,
    Date date,
    SeatDto seat,
    List<BaggageDto> baggages,
    List<SeatDto> avaibleSeats,
    PassangerDto passanger
  ) {
    this.checkInId = checkInId;
    this.flightId = flightId;
    this.date = date;
    this.seat = seat;
    this.baggages = baggages;
    this.avaibleSeats = avaibleSeats;
    this.passanger = passanger;
  }
}
