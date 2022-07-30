package rules;

import core.BusinessRule;

public class SeatCodeRule implements BusinessRule {

  private static final float MAX_LENGHT = 5;
  private final String value;

  public SeatCodeRule(String value) {
    this.value = value;
  }

  @Override
  public boolean isValid() {
    return value.length() <= 5;
  }

  @Override
  public String getMessage() {
    return "The seat code length can not be greater than " + MAX_LENGHT;
  }
}
