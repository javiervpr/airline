package infraestructure.utils;

import core.BusinessRuleValidationException;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import java.util.Collections;
import java.util.List;
import model.Baggage;

public class BaggageUtils {

  public static BaggageJpaModel baggageToJpaEntity(
    Baggage baggage,
    CheckInJpaModel checkInJpaModel
  ) {
    BaggageJpaModel model = new BaggageJpaModel();
    model.setWeight(baggage.getWeight());
    model.setType(baggage.getType().toString());
    model.setId(baggage.getId());
    model.setCheckIn(checkInJpaModel);
    return model;
  }

  public static List<BaggageJpaModel> baggagesToJpaEntities(
    List<Baggage> baggages,
    CheckInJpaModel checkInJpaModel
  ) {
    if (baggages == null) return Collections.emptyList();
    return baggages
      .stream()
      .map((Baggage baggage) -> baggageToJpaEntity(baggage, checkInJpaModel))
      .toList();
  }

  public static Baggage jpaToBaggage(BaggageJpaModel jpaModel)
    throws BusinessRuleValidationException {
    return new Baggage(jpaModel.getWeight(), jpaModel.getCheckIn().getId());
  }
}
