package model;

import core.BusinessRuleValidationException;
import core.Entity;
import value.objects.BaggageWeightValue;

import java.util.UUID;

public class Baggage extends Entity {

    private BaggageWeightValue weight;
    private BaggageType type;

    public Baggage(float weight) throws BusinessRuleValidationException {
        this.id = UUID.randomUUID();
        this.weight = new BaggageWeightValue(weight);
        if (weight > 10 )
            type = BaggageType.CARRY_ON;
        else
            type = BaggageType.CHECKED_BAG;
    }

    public float getWeight() {
        return weight.getWeight();
    }

    public BaggageType getType() {
        return type;
    }
}
