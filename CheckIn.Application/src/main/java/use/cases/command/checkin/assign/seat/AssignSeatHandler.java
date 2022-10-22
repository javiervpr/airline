package use.cases.command.checkin.assign.seat;

import an.awesome.pipelinr.Command;

import java.util.UUID;

import com.amazonaws.services.sns.AmazonSNS;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.SeatDto;
import model.CheckIn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.SeatRepository;
import utils.SeatMapper;

@Component
public class AssignSeatHandler
        implements Command.Handler<AssignSeatCommand, SeatDto> {

    private final CheckInRepository checkInRepository;
    private final SeatRepository seatRepository;
    private AmazonSNS amazonSNSAsync;

    @Value("${cloud.aws.topics.assigned-seat-arn}")
    private String assignedSeatArn;

    public AssignSeatHandler(
            CheckInRepository checkInRepository,
            SeatRepository seatRepository,
            AmazonSNS amazonSNSAsync
    ) {
        this.checkInRepository = checkInRepository;
        this.seatRepository = seatRepository;
        this.amazonSNSAsync = amazonSNSAsync;
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
            if (checkIn.getOldSeat() != null)
                seatRepository.update(checkIn.getOldSeat());

            SeatDto seatDto = SeatMapper.from(checkIn.getSeat());
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(seatDto);
            this.amazonSNSAsync.publish(this.assignedSeatArn, json);
            return seatDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
