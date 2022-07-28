package rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaggageWeightRuleTests {

    public static final String INVALID_MESSAGE = "The weight can not be greater than 50.0";
    private BaggageWeightRule baggageWeightRule;

    @Test
    void testIsValidBaggageWeightRule() {
        baggageWeightRule = new BaggageWeightRule(20);
        assertTrue(baggageWeightRule.isValid());
    }

    @Test
    void testWeightLessThanZero() {
        baggageWeightRule = new BaggageWeightRule(-20);
        assertFalse(baggageWeightRule.isValid());
        assertEquals(INVALID_MESSAGE, baggageWeightRule.getMessage());
    }

    @Test
    void testWeightEqualZero() {
        baggageWeightRule = new BaggageWeightRule(0);
        assertFalse(baggageWeightRule.isValid());
        assertEquals(INVALID_MESSAGE, baggageWeightRule.getMessage());
    }

    @Test
    void testIsGreaterThanLimitWeight() {
        baggageWeightRule = new BaggageWeightRule(70);
        assertFalse(baggageWeightRule.isValid());
        assertEquals(INVALID_MESSAGE, baggageWeightRule.getMessage());
    }
}
