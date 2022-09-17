package controllers;

import an.awesome.pipelinr.Pipeline;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.*;

import java.util.UUID;

import model.BaggageType;
import model.CheckIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import use.cases.command.checkin.assign.seat.AssignSeatCommand;
import use.cases.command.checkin.create.checkin.CreateCheckInCommand;
import use.cases.command.checkin.tag.baggage.TagBaggaggeCommand;
import use.cases.command.flight.FlightSeatSyncCommand;
import use.cases.command.passenger.PassengerSyncCommand;

@RestController
public class CheckInController {


  Logger logger = LoggerFactory.getLogger(CheckInController.class);
  final Pipeline pipeline;
  private QueueMessagingTemplate queueMessagingTemplate;
  @Value("${cloud.aws.end-point.uri}")
  private String endpoint;

  public CheckInController(Pipeline pipeline, QueueMessagingTemplate queueMessagingTemplate) {
    this.pipeline = pipeline;
    this.queueMessagingTemplate = queueMessagingTemplate;
  }
//  public CheckInController(Pipeline pipeline) {
//    this.pipeline = pipeline;
//  }

  @PostMapping("/assign-seat")
  public String assignSeat(@RequestBody CheckInDto checkInDto) throws JsonProcessingException {
    AssignSeatCommand assignSeatCommand = new AssignSeatCommand(checkInDto);
    SeatDto response = assignSeatCommand.execute(pipeline);

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(response);
    queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(json).build());
    logger.info("llego");
    return json;
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

  @GetMapping("/test-queue/{message}")
  public String testQueue(@PathVariable String message) throws JsonProcessingException {
    BaggageDto baggageDto = new BaggageDto();
    baggageDto.checkInId = UUID.randomUUID().toString();
    baggageDto.type = BaggageType.CHECKED_BAG.toString();
    baggageDto.weight = 20;
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(baggageDto);
    queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(json).build());
    return message;
  }

  @SqsListener("flights")
  public void listenFlightQueue(String message) throws JsonProcessingException {
    logger.info("message from SQS Queue {}",message);
    ObjectMapper objectMapper = new ObjectMapper();
    FlightDto flightDto = objectMapper.readValue(message, FlightDto.class);
    FlightSeatSyncCommand command = new FlightSeatSyncCommand(flightDto);
    command.execute(pipeline);
    logger.info("message from SQS Queue decoded {}",flightDto.toString());
    logger.info("message from SQS Queue decoded {}",flightDto.flight.information.avaibleSeats.toString());
  }

  @SqsListener("passengers_queue")
  public void listenPassengerQueue(String message) throws JsonProcessingException {
    logger.info("message from SQS Queue {}",message);
    ObjectMapper objectMapper = new ObjectMapper();
    PassengerSyncDto passengerSyncDto = objectMapper.readValue(message, PassengerSyncDto.class);
    PassengerSyncCommand command = new PassengerSyncCommand(passengerSyncDto);
    command.execute(pipeline);
  }
}
