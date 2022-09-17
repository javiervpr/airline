package model;

import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.SeatJpaModel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        UUID id = UUID.randomUUID();
        CheckInJpaModel jpaModel = new CheckInJpaModel();
        jpaModel.setId(id);
        jpaModel.setSeat(seatJpaModel);
        jpaModel.setBaggages(List.of(baggageJpa));

        assertEquals(id, jpaModel.getId());
    }
}
