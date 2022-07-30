package builder;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Baggage;

public class BaggageBuilder {

  private float weight = 10;
  private UUID checkInId = UUID.randomUUID();

  public Baggage build() throws BusinessRuleValidationException {
    return new Baggage(weight, checkInId);
  }

  public BaggageBuilder withWeight(float weight) {
    this.weight = weight;
    return this;
  }

  public BaggageBuilder withCheckInId(UUID checkInId) {
    this.checkInId = checkInId;
    return this;
  }
}
