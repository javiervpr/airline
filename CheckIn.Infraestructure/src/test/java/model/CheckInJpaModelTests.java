package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PassangerJpaModel;
import infraestructure.model.SeatJpaModel;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CheckInJpaModelTests {

  @Test
  void testCheckInJpaModel() {
    UUID flightId = UUID.randomUUID();
    UUID seatCode = UUID.randomUUID();
    SeatJpaModel seatJpaModel = new SeatJpaModel();
    seatJpaModel.setFlightId(flightId);
    seatJpaModel.setType(SeatType.ECONOMY.toString());
    seatJpaModel.setStatus(SeatStatus.FREE.toString());
    seatJpaModel.setCode(seatCode);

    UUID idBaggage = UUID.randomUUID();
    BaggageJpaModel baggageJpa = new BaggageJpaModel();
    baggageJpa.setWeight(20);
    baggageJpa.setType(BaggageType.CHECKED_BAG.toString());
    baggageJpa.setId(idBaggage);

    UUID idPassenger = UUID.randomUUID();
    PassangerJpaModel passangerJpaModel = new PassangerJpaModel();
    passangerJpaModel.setId(idPassenger);

    Date newDate = new Date();

    UUID id = UUID.randomUUID();
    CheckInJpaModel jpaModel = new CheckInJpaModel();
    jpaModel.setId(id);
    jpaModel.setSeat(seatJpaModel);
    jpaModel.setBaggages(List.of(baggageJpa));
    jpaModel.setDate(newDate);
    jpaModel.setFlightId(flightId);
    jpaModel.setPassanger(passangerJpaModel);

    assertEquals(id, jpaModel.getId());
    assertEquals(List.of(baggageJpa), jpaModel.getBaggages());
    assertEquals(flightId, jpaModel.getFlightId());
    assertEquals(seatJpaModel, jpaModel.getSeat());
    assertEquals(passangerJpaModel, jpaModel.getPassanger());
    assertEquals(newDate, jpaModel.getDate());
  }
}
