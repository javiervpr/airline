package model;

import infraestructure.model.SeatJpaModel;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(flightId, jpaModel.getFlightId());
        assertEquals(seatCode, jpaModel.getCode());
        assertEquals(SeatType.ECONOMY.toString(), jpaModel.getType());
        assertEquals(SeatStatus.FREE.toString(), jpaModel.getStatus());
    }
}
