package model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SeatTests {

    public static final UUID CODE = UUID.randomUUID();
    public static final SeatType ECONOMY_TYPE = SeatType.ECONOMY;
    public static final SeatStatus FREE_STATUS = SeatStatus.FREE;
    public static final UUID FLIGHT_ID = UUID.randomUUID();
    private Seat seat;

    @Test
    void testSeatCreation() {
        assertDoesNotThrow(() -> {
            seat = new Seat(CODE,ECONOMY_TYPE,FREE_STATUS,FLIGHT_ID);
        });
        assertNotNull(seat.getId());
        assertEquals(CODE, seat.getCode());
        assertEquals(ECONOMY_TYPE, seat.getType());
        assertEquals(FREE_STATUS, seat.getStatus());
        assertEquals(FLIGHT_ID, seat.getFlightId());
    }
}
