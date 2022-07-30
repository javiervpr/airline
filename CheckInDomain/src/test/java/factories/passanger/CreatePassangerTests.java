package factories.passanger;

import static org.junit.jupiter.api.Assertions.*;

import core.BusinessRuleValidationException;
import factories.check.in.CreateCheckIn;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatePassangerTests {

  PassangerFactory passangerFactory;

  @BeforeEach
  void setUp() {
    passangerFactory = new CreatePassanger();
  }

  @AfterEach
  void tearDown() {
    passangerFactory = null;
  }

  @Test
  void testCreate() throws BusinessRuleValidationException {
    Passanger passanger = passangerFactory.create(
      "Juan",
      "Ramirez",
      new Date(),
      "987423",
      true
    );
    assertEquals("Juan", passanger.getName());
    assertEquals("Ramirez", passanger.getLastname());
    assertEquals("987423", passanger.getCi());
    assertTrue(passanger.isNeedAssistance());
  }
}
