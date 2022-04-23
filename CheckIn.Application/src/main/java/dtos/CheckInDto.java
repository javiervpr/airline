package dtos;

import java.util.Date;
import java.util.List;

public class CheckInDto {

    private String flightId;
    private Date date;
    private SeatDto seat;
    private BaggageDto baggage;
    private List<SeatDto> avaibleSeats;
    private PassangerDto passanger;

    public CheckInDto() {
    }

    public CheckInDto(String flightId, Date date, SeatDto seat, BaggageDto baggage, List<SeatDto> avaibleSeats, PassangerDto passanger) {
        this.flightId = flightId;
        this.date = date;
        this.seat = seat;
        this.baggage = baggage;
        this.avaibleSeats = avaibleSeats;
        this.passanger = passanger;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SeatDto getSeat() {
        return seat;
    }

    public void setSeat(SeatDto seat) {
        this.seat = seat;
    }

    public BaggageDto getBaggage() {
        return baggage;
    }

    public void setBaggage(BaggageDto baggage) {
        this.baggage = baggage;
    }

    public List<SeatDto> getAvaibleSeats() {
        return avaibleSeats;
    }

    public void setAvaibleSeats(List<SeatDto> avaibleSeats) {
        this.avaibleSeats = avaibleSeats;
    }

    public PassangerDto getPassanger() {
        return passanger;
    }

    public void setPassanger(PassangerDto passanger) {
        this.passanger = passanger;
    }
}
