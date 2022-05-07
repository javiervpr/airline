package controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.CheckInDto;
import model.CheckIn;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repositories.CheckInRepository;
import use.cases.command.checkIn.assign.seat.AssignSeatCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
public class CheckInController {

    final Pipeline pipeline;

    public CheckInController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }


    @PostMapping("/assign-seat")
    public UUID assignSeat(@RequestBody CheckInDto checkInDto) {
        AssignSeatCommand assignSeatCommand = new AssignSeatCommand(checkInDto);
        return assignSeatCommand.execute(pipeline);
    }


}
