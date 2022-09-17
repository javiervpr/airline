package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.SeatJpaModel;
import java.util.Collections;
import java.util.List;
import model.Seat;
import model.SeatStatus;
import model.SeatType;

@Generated
public class SeatUtils {

  public static SeatJpaModel seatToJpaEntity(Seat seat) {
    if (seat == null) return null;
    SeatJpaModel seatJpaModel = new SeatJpaModel();
    seatJpaModel.setType(seat.getType().toString());
    seatJpaModel.setCode(seat.getCode());
    seatJpaModel.setStatus(seat.getStatus().toString());
    seatJpaModel.setFlightId(seat.getFlightId());
    return seatJpaModel;
  }

  public static List<SeatJpaModel> seatsToJpaEntities(List<Seat> seats) {
    if (seats == null) return Collections.emptyList();
    return seats.stream().map(SeatUtils::seatToJpaEntity).toList();
  }

  public static Seat jpaModelToSeat(SeatJpaModel jpaModel)
    throws BusinessRuleValidationException {
    return new Seat(
      jpaModel.getCode(),
      SeatType.valueOf(jpaModel.getType()),
      SeatStatus.valueOf(jpaModel.getStatus()),
      jpaModel.getFlightId()
    );
  }
}
