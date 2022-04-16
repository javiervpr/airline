package model;

import core.BusinessRuleValidationException;
import core.Entity;
import value.objects.SeatCodeValue;

public class Seat extends Entity {

    private SeatCodeValue code;
    private SeatType type;
    private SeatStatus status;

    public Seat(String code, SeatType type, SeatStatus status) throws BusinessRuleValidationException {
        this.code = new SeatCodeValue(code);
        this.type = type;
        this.status = status;
    }

    public String getCode() {
        return code.getCode();
    }

    public SeatType getType() {
        return type;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
