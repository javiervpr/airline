package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class PassangerTests {

  private static final String NAME = "Javier";
  private static final String LAST_NAME = "Vaca Pereira Roca";
  private static final Date BIRTHDAY = new Date();
  private static final String CI = "912112";
  private static final boolean NEED_ASSISTANCE = false;
  private Passanger passanger;

  @Test
  void testCreation() {
    assertDoesNotThrow(() -> {
      passanger = new Passanger(NAME, LAST_NAME, BIRTHDAY, CI, NEED_ASSISTANCE);
    });
    assertNotNull(passanger.getId());
    assertEquals(NAME, passanger.getName());
    assertEquals(LAST_NAME, passanger.getLastname());
    assertEquals(BIRTHDAY, passanger.getBirthday());
    assertEquals(CI, passanger.getCi());
    assertEquals(NEED_ASSISTANCE, passanger.isNeedAssistance());
  }

  @Test
  void testCreationWithId() {
    assertDoesNotThrow(() -> {
      passanger =
        new Passanger(
          UUID.randomUUID(),
          NAME,
          LAST_NAME,
          BIRTHDAY,
          CI,
          NEED_ASSISTANCE
        );
    });
    assertNotNull(passanger.getId());
    assertEquals(NAME, passanger.getName());
    assertEquals(LAST_NAME, passanger.getLastname());
    assertEquals(BIRTHDAY, passanger.getBirthday());
    assertEquals(CI, passanger.getCi());
    assertEquals(NEED_ASSISTANCE, passanger.isNeedAssistance());
  }
}
