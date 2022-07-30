package infraestructure.repositories.baggage;

import core.BusinessRuleValidationException;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.repositories.check.in.CheckInCrudRepository;
import infraestructure.utils.BaggageUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import model.Baggage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositories.BaggageRepository;

@Repository
public class BaggageJpaRepository implements BaggageRepository {

  @Autowired
  private BaggageCrudRepository baggageCrudRepository;

  @Autowired
  CheckInCrudRepository checkInCrudRepository;

  @Override
  public UUID update(Baggage baggage) {
    CheckInJpaModel checkInJpaModel = checkInCrudRepository
      .findById(baggage.getCheckInId())
      .orElse(null);
    if (checkInJpaModel == null) return null;
    BaggageJpaModel jpaModel = BaggageUtils.baggageToJpaEntity(
      baggage,
      checkInJpaModel
    );
    return baggageCrudRepository.save(jpaModel).getId();
  }

  @Override
  public List<Baggage> findByCheckInId(UUID checkInId)
    throws BusinessRuleValidationException {
    CheckInJpaModel checkInJpaModel = checkInCrudRepository
      .findById(checkInId)
      .orElse(null);
    if (checkInJpaModel == null) return Collections.emptyList();

    List<BaggageJpaModel> jpaModels = baggageCrudRepository.findByCheckIn(
      checkInJpaModel
    );
    List<Baggage> baggages = new ArrayList<>();
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    for (BaggageJpaModel jpaModel : jpaModels) {
      baggages.add(BaggageUtils.jpaToBaggage(jpaModel));
    }
    return baggages;
  }
}
