package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BaggageJpaModelTests {

  @Test
  void testBaggageJpaModelCreation() {
    CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
    checkInJpaModel.setId(UUID.randomUUID());

    UUID id = UUID.randomUUID();
    BaggageJpaModel jpaModel = new BaggageJpaModel();
    jpaModel.setCheckIn(checkInJpaModel);
    jpaModel.setWeight(20);
    jpaModel.setType(BaggageType.CHECKED_BAG.toString());
    jpaModel.setId(id);

    assertEquals(id, jpaModel.getId());
    assertEquals(20, jpaModel.getWeight());
    assertEquals(BaggageType.CHECKED_BAG.toString(), jpaModel.getType());
    assertEquals(checkInJpaModel.getId(), jpaModel.getCheckIn().getId());
  }
}
