package builder;

import factories.check.in.CheckInFactory;
import factories.seat.SeatFactory;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;

public class AssignSeatHandlerBuilder {

    private CheckInRepository checkInRepository;
    private PassangerRepository passangerRepository;
    private SeatRepository seatRepository;
    private CheckInFactory checkInFactory;
    private SeatFactory seatFactory;

    public AssignSeatHandlerBuilder withCheckIn (CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
        return this;
    }

    public AssignSeatHandlerBuilder withPassangerRepository(PassangerRepository passangerRepository) {
        this.passangerRepository = passangerRepository;
        return this;
    }

    public AssignSeatHandlerBuilder withSeatRepository(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
        return this;
    }

    public AssignSeatHandlerBuilder withCheckInFactory(CheckInFactory checkInFactory) {
        this.checkInFactory = checkInFactory;
        return this;
    }

    public AssignSeatHandlerBuilder withSeatFactory(SeatFactory seatFactory) {
        this.seatFactory = seatFactory;
        return this;
    }

}
