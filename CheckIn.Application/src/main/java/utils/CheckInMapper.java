package utils;

import dtos.BaggageDto;
import dtos.CheckInDto;
import dtos.SeatDto;
import model.CheckIn;

import java.util.ArrayList;
import java.util.List;

public class CheckInMapper {

    public static CheckInDto from(CheckIn checkIn) {
        if (checkIn == null)
            return new CheckInDto();
        List<BaggageDto> baggages = checkIn.getBaggages() == null ? new ArrayList<>() :
                checkIn.getBaggages().stream().map(BaggageMapper::from).toList();
        List<SeatDto> availableSeats = checkIn.getAvaibleSeats() == null ? new ArrayList<>() :
                checkIn.getAvaibleSeats().stream().map(SeatMapper::from).toList();
        return new CheckInDto(
                checkIn.getId().toString(),
                checkIn.getFlightId().toString(),
                checkIn.getDate(),
                SeatMapper.from(checkIn.getSeat()),
                baggages,
                availableSeats,
                PassangerMapper.from(checkIn.getPassanger())
        );
    }
}
