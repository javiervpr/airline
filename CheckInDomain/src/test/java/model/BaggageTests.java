package model;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BaggageTests {

    @Test
    void testBaggageCheckedBag() {
        try {
            UUID checkInId = UUID.randomUUID();
            Baggage baggage = new Baggage(35, checkInId);
            assertEquals(35, baggage.getWeight());
            assertEquals(BaggageType.CHECKED_BAG, baggage.getType());
            assertEquals(checkInId, baggage.getCheckInId());
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void testBaggageCarryOn() {
        try {
            UUID checkInId = UUID.randomUUID();
            Baggage baggage = new Baggage(9, checkInId);
            assertEquals(9, baggage.getWeight());
            assertEquals(BaggageType.CARRY_ON, baggage.getType());
            assertEquals(checkInId, baggage.getCheckInId());
        } catch (BusinessRuleValidationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
