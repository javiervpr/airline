package rules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SeatCodeRuleTests {

  public static final String INVALID_MESSAGE =
    "The seat code length can not be greater than 5.0";
  public static final String VALID_CODE = "20F21";
  public static final String INVALID_CODE = "1FS2312";
  private SeatCodeRule seatCodeRule;

  @Test
  void testIsValidBaggageWeightRule() {
    seatCodeRule = new SeatCodeRule(VALID_CODE);
    assertTrue(seatCodeRule.isValid());
  }

  @Test
  void testWeightLessThanZero() {
    seatCodeRule = new SeatCodeRule(INVALID_CODE);
    assertFalse(seatCodeRule.isValid());
    assertEquals(INVALID_MESSAGE, seatCodeRule.getMessage());
  }
}
