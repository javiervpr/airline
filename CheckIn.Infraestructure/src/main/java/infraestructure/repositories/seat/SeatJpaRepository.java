package infraestructure.repositories.seat;

import core.BusinessRuleValidationException;
import infraestructure.model.SeatJpaModel;
import infraestructure.utils.SeatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositories.SeatRepository;

@Repository
public class SeatJpaRepository implements SeatRepository {

  @Autowired
  private SeatCrudRepository seatCrudRepository;

  @Override
  public UUID update(Seat seat) {
    SeatJpaModel seatJpaModel = SeatUtils.seatToJpaEntity(seat);
    return seatCrudRepository.save(seatJpaModel).getCode();
  }

  @Override
  public List<Seat> findByFlightIdAndStatus(UUID flightId, String status)
    throws BusinessRuleValidationException {
    List<SeatJpaModel> jpaModels = seatCrudRepository.findByFlightIdAndStatus(
      flightId,
      status
    );
    if (
      jpaModels == null || jpaModels.size() == 0
    ) return Collections.emptyList();
    List<Seat> seats = new ArrayList<>();
    for (SeatJpaModel jpaModel : jpaModels) {
      seats.add(SeatUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }

  @Override
  public List<Seat> findByFlightId(UUID flightId)
    throws BusinessRuleValidationException {
    List<SeatJpaModel> jpaModels = seatCrudRepository.findByFlightId(flightId);
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    List<Seat> seats = new ArrayList<>();
    for (SeatJpaModel jpaModel : jpaModels) {
      seats.add(SeatUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }

  public void setSeatCrudRepository(SeatCrudRepository seatCrudRepository) {
    this.seatCrudRepository = seatCrudRepository;
  }
}
