package value.objects;

import static org.junit.jupiter.api.Assertions.*;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;
import rules.SeatCodeRuleTests;

class SeatCodeValueTests {

  private SeatCodeValue seatCodeValue;

  @Test
  void testValidCreation() {
    assertDoesNotThrow(() -> {
      seatCodeValue = new SeatCodeValue(SeatCodeRuleTests.VALID_CODE);
    });
    assertEquals(SeatCodeRuleTests.VALID_CODE, seatCodeValue.getCode());
  }

  @Test
  void testInvalidCode() {
    BusinessRuleValidationException validationException = assertThrows(
      BusinessRuleValidationException.class,
      () -> {
        seatCodeValue = new SeatCodeValue(SeatCodeRuleTests.INVALID_CODE);
      }
    );
    assertEquals(
      SeatCodeRuleTests.INVALID_MESSAGE,
      validationException.getMessage()
    );
  }
}
