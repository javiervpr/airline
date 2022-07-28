package use.cases.command.checkIn.assign.seat;

import builder.AssignSeatCommandBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;

import static org.mockito.Mockito.when;

public class AssignSeatHandlerTests {

    @Mock
    CheckInRepository checkInRepository;
    @Mock
    PassangerRepository passangerRepository;
    @Mock
    SeatRepository seatRepository;

    @Test
    void init() {
        AssignSeatCommand request = new AssignSeatCommandBuilder().build();
        AssignSeatHandler assignSeatHandler = new AssignSeatHandler(checkInRepository, passangerRepository, seatRepository);
//        when(checkInRepository.findByPassangerAndFlightId)

        assignSeatHandler.handle(request);


    }
}
