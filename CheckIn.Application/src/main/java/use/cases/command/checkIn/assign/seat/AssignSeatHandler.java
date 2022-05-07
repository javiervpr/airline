package use.cases.command.checkIn.assign.seat;

import an.awesome.pipelinr.Command;
import dtos.SeatDto;
import factories.check.in.CheckInFactory;
import factories.check.in.CreateCheckIn;
import factories.seat.CreateSeat;
import factories.seat.SeatFactory;
import model.CheckIn;
import model.Passanger;
import model.Seat;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;

import java.util.List;
import java.util.UUID;

@Component
public class AssignSeatHandler implements  Command.Handler<AssignSeatCommand, UUID> {

    private final CheckInRepository checkInRepository;
    private final PassangerRepository passangerRepository;
    private final SeatRepository seatRepository;
    private final CheckInFactory checkInFactory;
    private final SeatFactory seatFactory;

    public AssignSeatHandler(CheckInRepository checkInRepository, PassangerRepository passangerRepository, SeatRepository seatRepository) {
        this.checkInRepository = checkInRepository;
        this.passangerRepository = passangerRepository;
        this.seatRepository = seatRepository;
        this.checkInFactory = new CreateCheckIn();
        this.seatFactory = new CreateSeat();
    }

    @Override
    public UUID handle(AssignSeatCommand request) {
        try {
            for (SeatDto seatDto: request.checkInDto.avaibleSeats) {
                Seat seat = seatFactory.create(seatDto.code, seatDto.type, seatDto.status,request.checkInDto.flightId);
                seatRepository.update(seat);
            }

            Passanger passanger = this.passangerRepository.get(UUID.fromString(request.checkInDto.passanger.id));

            List<Seat> avaibleSeats = request.checkInDto.avaibleSeats.stream().map(seatDto -> {
                try {
                    return seatFactory.create(seatDto.code, seatDto.type, seatDto.status, request.checkInDto.flightId);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }).toList();

            CheckIn checkIn = checkInRepository.findByPassangerAndFlightId(UUID.fromString(request.checkInDto.passanger.id),
                                                            UUID.fromString(request.checkInDto.flightId));
            if (checkIn == null){
                checkIn = checkInFactory.create(UUID.fromString(request.checkInDto.flightId), avaibleSeats, passanger);
            }

            checkIn.assignSeat(UUID.fromString(request.checkInDto.seat.code));
            checkInRepository.update(checkIn);
            return checkIn.getId();
        } catch ( Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
