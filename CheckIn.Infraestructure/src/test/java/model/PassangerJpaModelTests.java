package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import infraestructure.model.PassangerJpaModel;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class PassangerJpaModelTests {

  @Test
  void testPassangerJpaModel() {
    UUID id = UUID.randomUUID();
    Date birthday = new Date();
    PassangerJpaModel jpaModel = new PassangerJpaModel();
    jpaModel.setId(id);
    jpaModel.setName("Javier");
    jpaModel.setLastname("Vaca Pereira Roca");
    jpaModel.setNeedAssistance(false);
    jpaModel.setBirthday(birthday);
    jpaModel.setCi("31231");

    assertEquals(id, jpaModel.getId());
    assertEquals("Javier", jpaModel.getName());
    assertEquals("Vaca Pereira Roca", jpaModel.getLastname());
    assertFalse(jpaModel.isNeedAssistance());
    assertEquals(birthday, jpaModel.getBirthday());
    assertEquals("31231", jpaModel.getCi());
  }
}
