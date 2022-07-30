package rules;

import core.BusinessRule;

public class NotNullRule implements BusinessRule {

  private final Object object;

  public NotNullRule(Object object) {
    this.object = object;
  }

  @Override
  public boolean isValid() {
    return this.object != null;
  }

  @Override
  public String getMessage() {
    return "Object can not be null";
  }
}
