package controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.CheckInDto;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.checkin.assign.seat.AssignSeatCommand;
import use.cases.command.checkin.create.checkin.CreateCheckInCommand;
import use.cases.command.checkin.tag.baggage.TagBaggaggeCommand;

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

  @PostMapping("/tag-baggage")
  public UUID tagBaggage(@RequestBody CheckInDto checkInDto) {
    TagBaggaggeCommand tagBaggaggeCommand = new TagBaggaggeCommand(checkInDto);
    return tagBaggaggeCommand.execute(pipeline);
  }

  @PostMapping("/create-checkin")
  public UUID createCheckIn(@RequestBody CheckInDto checkInDto) {
    CreateCheckInCommand createCheckInCommand = new CreateCheckInCommand(
      checkInDto
    );
    return createCheckInCommand.execute(pipeline);
  }
}
