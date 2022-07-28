package model;

import core.BusinessRuleValidationException;
import core.Entity;
import value.objects.BaggageWeightValue;

import java.util.UUID;

public class Baggage extends Entity {

    private BaggageWeightValue weight;
    private BaggageType type;
    private UUID checkInId;

    public Baggage(float weight, UUID checkInId) throws BusinessRuleValidationException {
        this.id = UUID.randomUUID();
        this.weight = new BaggageWeightValue(weight);
        this.checkInId = checkInId;
        if (weight > 10 )
            type = BaggageType.CHECKED_BAG;
        else
            type = BaggageType.CARRY_ON;
    }

    public float getWeight() {
        return weight.getWeight();
    }

    public BaggageType getType() {
        return type;
    }

    public UUID getCheckInId() {
        return checkInId;
    }
}
