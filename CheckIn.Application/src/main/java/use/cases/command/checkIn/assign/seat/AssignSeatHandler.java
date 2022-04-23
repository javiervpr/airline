package use.cases.command.checkIn.assign.seat;

import core.BusinessRuleValidationException;
import factories.check.in.CheckInFactory;
import factories.passanger.PassangerFactory;
import factories.seat.SeatFactory;
import model.CheckIn;
import model.Passanger;
import model.Seat;
import repositories.CheckInRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AssignSeatHandler {

    private final CheckInRepository checkInRepository;
    private final CheckInFactory checkInFactory;
    private final PassangerFactory passangerFactory;
    private final SeatFactory seatFactory;

    public AssignSeatHandler(CheckInRepository checkInRepository, CheckInFactory checkInFactory, PassangerFactory passangerFactory, SeatFactory seatFactory) {
        this.checkInRepository = checkInRepository;
        this.checkInFactory = checkInFactory;
        this.passangerFactory = passangerFactory;
        this.seatFactory = seatFactory;
    }

    public UUID handle(AssignSeatCommand request) throws BusinessRuleValidationException {
        Passanger passanger = passangerFactory.create(request.checkInDto.getPassanger().getName(),
                                                    request.checkInDto.getPassanger().getLastname(),
                                                    request.checkInDto.getPassanger().getBirthday(),
                                                    request.checkInDto.getPassanger().getCi(),
                                                    request.checkInDto.getPassanger().isNeedAssistance()
                );
        List<Seat> avaibleSeats = request.checkInDto.getAvaibleSeats().stream().map(seatDto -> {
            try {
                return seatFactory.create(request.checkInDto.getSeat().getCode(), request.checkInDto.getSeat().getType(), request.checkInDto.getSeat().getStatus());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

        CheckIn checkIn = checkInFactory.create(UUID.fromString(request.checkInDto.getFlightId()), avaibleSeats, passanger);
        Seat seat = seatFactory.create(request.checkInDto.getSeat().getCode(), request.checkInDto.getSeat().getType(), request.checkInDto.getSeat().getStatus());
        checkIn.assignSeat(UUID.fromString(seat.getCode()));
        return checkIn.getId();
    }
}
