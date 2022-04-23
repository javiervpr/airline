package factories.passanger;

import core.BusinessRuleValidationException;
import model.Passanger;

import java.util.Date;

public interface PassangerFactory {

    Passanger create(String name, String lastname, Date birthday, String ci, boolean needAssistance) throws BusinessRuleValidationException;
}
