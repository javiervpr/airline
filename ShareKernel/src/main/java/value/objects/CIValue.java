package value.objects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.CIRule;
import rules.StringNotNullOrEmptyRule;

public class CIValue extends ValueObject {

  private final String ci;

  public CIValue(String ci) throws BusinessRuleValidationException {
    checkRule(new StringNotNullOrEmptyRule(ci));
    checkRule(new CIRule(ci));
    this.ci = ci;
  }

  public String getCi() {
    return ci;
  }
}
