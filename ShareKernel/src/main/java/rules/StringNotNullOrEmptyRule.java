package rules;

import core.BusinessRule;

public class StringNotNullOrEmptyRule implements BusinessRule {

  private final String value;

  public StringNotNullOrEmptyRule(String value) {
    this.value = value;
  }

  @Override
  public boolean isValid() {
    return value != null || !value.isEmpty();
  }

  @Override
  public String getMessage() {
    return "String can not be null";
  }
}
