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

    public CheckInDto() { }

}
