package value.objects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.PersonNameRule;
import rules.StringNotNullOrEmptyRule;

public class PersonNameValue extends ValueObject {

  private String name;

  public PersonNameValue(String name) throws BusinessRuleValidationException {
    checkRule(new StringNotNullOrEmptyRule(name));
    checkRule(new PersonNameRule(name));
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
