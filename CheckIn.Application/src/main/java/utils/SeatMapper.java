package utils;

import core.BusinessRuleValidationException;
import dtos.SeatDto;
import java.util.UUID;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

public final class SeatMapper {

  public static SeatDto from(Seat seat) {
    return new SeatDto(
      seat.getCode().toString(),
      seat.getType().toString(),
      seat.getStatus().toString()
    );
  }
  //    public static Seat from(SeatDto seatDto) throws BusinessRuleValidationException {
  //        return new Seat(UUID.fromString(seatDto.code),
  //                SeatType.valueOf(seatDto.type),
  //                SeatStatus.valueOf(seatDto.status),
  //                UUID.fromString(seatDto.));
  //    }
}
