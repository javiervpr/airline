package controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.*;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.checkin.assign.seat.AssignSeatCommand;
import use.cases.command.checkin.create.checkin.CreateCheckInCommand;
import use.cases.command.checkin.get.checkin.GetCheckInQuery;
import use.cases.command.checkin.seats.GetSeatsByFlightQuery;
import use.cases.command.checkin.tag.baggage.TagBaggaggeCommand;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CheckInController {

  Logger logger = LoggerFactory.getLogger(CheckInController.class);
  final Pipeline pipeline;

  public CheckInController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/assign-seat")
  public SeatDto assignSeat(@RequestBody CheckInDto checkInDto) {
    AssignSeatCommand assignSeatCommand = new AssignSeatCommand(checkInDto);
    return assignSeatCommand.execute(pipeline);
  }

  @PostMapping("/tag-baggage")
  public UUID tagBaggage(@RequestBody CheckInDto checkInDto) {
    TagBaggaggeCommand tagBaggaggeCommand = new TagBaggaggeCommand(checkInDto);
    return tagBaggaggeCommand.execute(pipeline);
  }

  @PostMapping("/create-checkin")
  public CheckInDto createCheckIn(@RequestBody CheckInDto checkInDto) {
    CreateCheckInCommand createCheckInCommand = new CreateCheckInCommand(checkInDto);
    return createCheckInCommand.execute(pipeline);
  }

  @GetMapping("/checkIn/{flightId}/{passengerId}")
  public CheckInDto getCheckIn(@PathVariable String flightId, @PathVariable String passengerId) {
    GetCheckInQuery query = new GetCheckInQuery(flightId, passengerId);
    return query.execute(pipeline);
  }

}
