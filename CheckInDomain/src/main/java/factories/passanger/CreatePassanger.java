package factories.passanger;

import core.BusinessRuleValidationException;
import model.Passanger;

import java.util.Date;

public class CreatePassanger implements PassangerFactory{
    @Override
    public Passanger create(String name, String lastname, Date birthday, String ci, boolean needAssistance) throws BusinessRuleValidationException {
        return new Passanger(name, lastname, birthday, ci, needAssistance);
    }
}
