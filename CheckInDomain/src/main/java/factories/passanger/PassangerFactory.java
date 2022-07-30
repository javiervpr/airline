package factories.passanger;

import core.BusinessRuleValidationException;
import java.util.Date;
import model.Passanger;

public interface PassangerFactory {
  Passanger create(
    String name,
    String lastname,
    Date birthday,
    String ci,
    boolean needAssistance
  ) throws BusinessRuleValidationException;
}
