package infraestructure.repositories.check.in;

import core.BusinessRuleValidationException;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PassangerJpaModel;
import infraestructure.model.SeatJpaModel;

import java.util.Collections;

import infraestructure.repositories.passanger.PassangerCrudRepository;
import infraestructure.repositories.seat.SeatCrudRepository;
import infraestructure.utils.BaggageUtils;
import infraestructure.utils.CheckInUtils;
import infraestructure.utils.PassangerUtils;
import infraestructure.utils.SeatUtils;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositories.CheckInRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class CheckInJpaRepository implements CheckInRepository {

    @Autowired
    private CheckInCrudRepository checkInCrudRepository;

    @Autowired
    private PassangerCrudRepository passangerCrudRepository;

    @Autowired
    private SeatCrudRepository seatCrudRepository;

    @Override
    @Transactional
    public UUID update(CheckIn checkIn) {
        CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
        checkInJpaModel.setFlightId(checkIn.getFlightId());
        checkInJpaModel.setDate(checkIn.getDate());
        checkInJpaModel.setFlightId(checkIn.getFlightId());
        checkInJpaModel.setId(checkIn.getId());
        checkInJpaModel.setPassanger(PassangerUtils.passangerToJpaEntity(checkIn.getPassanger()));
        checkInJpaModel.setBaggages(BaggageUtils.baggagesToJpaEntities(checkIn.getBaggages(), checkInJpaModel));
        if (checkIn.getSeat() != null) {
            checkInJpaModel.setSeat(SeatUtils.seatToJpaEntity(checkIn.getSeat()));
        }
        return checkInCrudRepository.save(checkInJpaModel).getId();
    }

    @Override
    public CheckIn get(UUID id) {
        return null;
    }

    @Override
    public CheckIn findByPassangerAndFlightId(UUID passenger, UUID flightId) throws BusinessRuleValidationException {
        PassangerJpaModel passangerJpaModel = passangerCrudRepository.findById(passenger).orElse(null);
        if (passangerJpaModel == null) return null;
        CheckInJpaModel model = checkInCrudRepository.findByPassangerAndFlightId(passangerJpaModel, flightId);
        if (model != null) {
            List<SeatJpaModel> seatsAvailable = seatCrudRepository.findByFlightIdAndStatus(flightId, SeatStatus.FREE.toString());
            return CheckInUtils.jpaModelToCheckIn(model, seatsAvailable);
        }
        return null;
    }

}
