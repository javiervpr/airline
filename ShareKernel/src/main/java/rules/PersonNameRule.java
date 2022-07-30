package rules;

import core.BusinessRule;

public class PersonNameRule implements BusinessRule {

  private static final int MAX_LENGHT = 500;
  private final String name;

  public PersonNameRule(String name) {
    this.name = name;
  }

  @Override
  public boolean isValid() {
    return name.length() < MAX_LENGHT;
  }

  @Override
  public String getMessage() {
    return "The name lenght can not be greater than " + MAX_LENGHT;
  }
}
