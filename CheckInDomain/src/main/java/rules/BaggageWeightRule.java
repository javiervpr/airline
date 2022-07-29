package rules;

import core.BusinessRule;

public class BaggageWeightRule implements BusinessRule {

  private final float weight;
  private static final float MAX_WEIGHT = 50;

  public BaggageWeightRule(float weight) {
    this.weight = weight;
  }

  @Override
  public boolean isValid() {
    return weight > 0 && weight <= MAX_WEIGHT;
  }

  @Override
  public String getMessage() {
    return "The weight can not be greater than " + MAX_WEIGHT;
  }
}
