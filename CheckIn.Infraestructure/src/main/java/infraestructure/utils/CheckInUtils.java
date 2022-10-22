package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.SeatJpaModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Baggage;
import model.CheckIn;
import model.Seat;

@Generated
public class CheckInUtils {

  public static CheckIn jpaModelToCheckIn(
    CheckInJpaModel jpaModel,
    List<SeatJpaModel> seats
  ) throws BusinessRuleValidationException {
    if (jpaModel == null) return null;
    List<Seat> seatsAvailable = new ArrayList<>();
    for (SeatJpaModel seatJpaModel : seats) {
      seatsAvailable.add(SeatUtils.jpaModelToSeat(seatJpaModel));
    }
    Seat seat = null;
    if (jpaModel.getSeat() != null) {
      seat = SeatUtils.jpaModelToSeat(jpaModel.getSeat());
    }

    List<Baggage> baggages = new ArrayList<>();
    for (BaggageJpaModel baggageJpaModel : jpaModel.getBaggages()) {
      baggages.add(BaggageUtils.jpaToBaggage(baggageJpaModel));
    }

    return new CheckIn(
      jpaModel.getId(),
      jpaModel.getFlightId(),
      seatsAvailable,
      PassangerUtils.jpaModelToPassanger(jpaModel.getPassanger()),
      seat,
      baggages
    );
  }
}
