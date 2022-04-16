package value.objects;

import core.BusinessRuleValidationException;
import core.ValueObject;

public class SeatCodeValue extends ValueObject {

    private final String code;

    public SeatCodeValue(String code) throws BusinessRuleValidationException {
        checkRule(new rules.SeatCodeRule(code));
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
