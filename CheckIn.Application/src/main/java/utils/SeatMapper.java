package utils;

import core.BusinessRuleValidationException;
import dtos.SeatDto;
import java.util.UUID;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

public final class SeatMapper {

  public static SeatDto from(Seat seat) {
    if (seat == null) return new SeatDto();
    return new SeatDto(
      seat.getCode() == null ? "" : seat.getCode().toString(),
      seat.getType() == null ? "" : seat.getType().toString(),
      seat.getStatus() == null ? "" : seat.getStatus().toString(),
      seat.getRowColumn() == null ? "" : seat.getRowColumn()
    );
  }
  //    public static Seat from(SeatDto seatDto) throws BusinessRuleValidationException {
  //        return new Seat(UUID.fromString(seatDto.code),
  //                SeatType.valueOf(seatDto.type),
  //                SeatStatus.valueOf(seatDto.status),
  //                UUID.fromString(seatDto.));
  //    }
}
