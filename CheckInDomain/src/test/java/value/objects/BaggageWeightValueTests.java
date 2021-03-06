package value.objects;

import static org.junit.jupiter.api.Assertions.*;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;
import rules.BaggageWeightRuleTests;

class BaggageWeightValueTests {

  private BaggageWeightValue baggageWeightValue;

  @Test
  void testCreationBaggageWeightValue() {
    assertDoesNotThrow(() -> {
      baggageWeightValue = new BaggageWeightValue(50);
    });
    assertEquals(50, baggageWeightValue.getWeight());
  }

  @Test
  void testInvalidCreationBaggageWeightValue() {
    BusinessRuleValidationException validationException = assertThrows(
      BusinessRuleValidationException.class,
      () -> {
        baggageWeightValue = new BaggageWeightValue(150);
      }
    );
    assertEquals(
      BaggageWeightRuleTests.INVALID_MESSAGE,
      validationException.getMessage()
    );
  }
}
