package builder;

import dtos.BaggageDto;
import dtos.CheckInDto;
import dtos.PassangerDto;
import dtos.SeatDto;
import model.SeatStatus;
import model.SeatType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckInDtoBuilder {

    private String checkInId = UUID.randomUUID().toString();
    private String flightId = UUID.randomUUID().toString();
    private Date date = new Date();
    private List<BaggageDto> baggages = new ArrayList<>();
    private List<SeatDto> avaibleSeats = new ArrayList<>();;
    private SeatDto seat;
    private PassangerDto passanger = new PassangerDto(UUID.randomUUID().toString(),"Javier","Suarez",new Date(),"123DA",false);


    public CheckInDto build() {
        return new CheckInDto(checkInId, flightId, date, seat,baggages,avaibleSeats,passanger);
    }
}
