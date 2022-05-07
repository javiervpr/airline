package infraestructure.utils;

import core.BusinessRuleValidationException;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.SeatJpaModel;
import model.CheckIn;
import model.Seat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckInUtils {

    public static CheckIn jpaModelToCheckIn(CheckInJpaModel jpaModel, List<SeatJpaModel> seats) throws BusinessRuleValidationException {
        if (jpaModel == null) return null;
        List<Seat> seatsAvailable = new ArrayList<>();
        for (SeatJpaModel seatJpaModel: seats) {
            seatsAvailable.add(SeatUtils.jpaModelToSeat(seatJpaModel));
        }
        return new CheckIn(jpaModel.getId(),jpaModel.getFlightId(),  seatsAvailable, PassangerUtils.jpaModelToPassanger(jpaModel.getPassanger()));
    }

}
