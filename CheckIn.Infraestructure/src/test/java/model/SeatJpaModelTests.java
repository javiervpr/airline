package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import infraestructure.model.SeatJpaModel;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class SeatJpaModelTests {

  @Test
  void testSeatJpaModel() {
    UUID flightId = UUID.randomUUID();
    UUID seatCode = UUID.randomUUID();
    SeatJpaModel jpaModel = new SeatJpaModel();
    jpaModel.setFlightId(flightId);
    jpaModel.setType(SeatType.ECONOMY.toString());
    jpaModel.setStatus(SeatStatus.FREE.toString());
    jpaModel.setCode(seatCode);
    jpaModel.setRowColumn("5_1");

    assertEquals(flightId, jpaModel.getFlightId());
    assertEquals(seatCode, jpaModel.getCode());
    assertEquals(SeatType.ECONOMY.toString(), jpaModel.getType());
    assertEquals(SeatStatus.FREE.toString(), jpaModel.getStatus());
    assertEquals("5_1", jpaModel.getRowColumn());
  }
}
