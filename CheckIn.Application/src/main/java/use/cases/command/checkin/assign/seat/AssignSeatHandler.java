package use.cases.command.checkin.assign.seat;

import an.awesome.pipelinr.Command;

import java.util.UUID;

import dtos.SeatDto;
import model.CheckIn;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;
import utils.SeatMapper;

@Component
public class AssignSeatHandler
        implements Command.Handler<AssignSeatCommand, SeatDto> {

    private final CheckInRepository checkInRepository;
    private final SeatRepository seatRepository;

    public AssignSeatHandler(
            CheckInRepository checkInRepository,
            PassangerRepository passangerRepository,
            SeatRepository seatRepository
    ) {
        this.checkInRepository = checkInRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public SeatDto handle(AssignSeatCommand request) {
        try {
            CheckIn checkIn = checkInRepository.findByPassangerAndFlightId(
                    UUID.fromString(request.checkInDto.passanger.id),
                    UUID.fromString(request.checkInDto.flightId)
            );
            checkIn.assignSeat(UUID.fromString(request.checkInDto.seat.code));
            checkInRepository.update(checkIn);
            seatRepository.update(checkIn.getSeat());
            return SeatMapper.from(checkIn.getSeat());
        } catch (Exception e) {
            return null;
        }
    }
}
