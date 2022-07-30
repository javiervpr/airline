package value.objects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.BaggageWeightRule;

public class BaggageWeightValue extends ValueObject {

  private final float weight;

  public BaggageWeightValue(float weight)
    throws BusinessRuleValidationException {
    checkRule(new BaggageWeightRule(weight));
    this.weight = weight;
  }

  public float getWeight() {
    return weight;
  }
}
