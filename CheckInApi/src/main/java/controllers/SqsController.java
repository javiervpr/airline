package controllers;

import an.awesome.pipelinr.Pipeline;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.FlightDto;
import dtos.PassengerSyncDto;
import dtos.PaymentCompleteDto;
import dtos.SNSDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.flight.FlightSeatSyncCommand;
import use.cases.command.passenger.PassengerSyncCommand;
import use.cases.command.ticket.TicketSyncCommand;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SqsController {

    Logger logger = LoggerFactory.getLogger(SqsController.class);
    final Pipeline pipeline;

    public SqsController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @SqsListener("flights_checkin")
    public void listenFlightQueue(String message) throws JsonProcessingException {
        logger.info("message from SQS Queue {}",message);
        ObjectMapper objectMapper = new ObjectMapper();
        SNSDto snsDto = objectMapper.readValue(message, SNSDto.class);
        FlightDto flightDto = objectMapper.readValue(snsDto.Message, FlightDto.class);
        FlightSeatSyncCommand command = new FlightSeatSyncCommand(flightDto);
        command.execute(pipeline);
        logger.info("message from SQS Queue decoded {}",flightDto.toString());
        logger.info("message from SQS Queue decoded {}",flightDto.data.flight.information.avaibleSeats.toString());
    }

    @SqsListener("passengers_checkin_queue")
    public void listenPassengerQueue(String message) throws JsonProcessingException {
        logger.info("message from SQS Queue {}",message);
        ObjectMapper objectMapper = new ObjectMapper();
        SNSDto snsDto = objectMapper.readValue(message, SNSDto.class);
        PassengerSyncDto passengerSyncDto = objectMapper.readValue(snsDto.Message, PassengerSyncDto.class);
        PassengerSyncCommand command = new PassengerSyncCommand(passengerSyncDto);
        command.execute(pipeline);
    }

    @SqsListener("reserva_pagada_checkin")
    public void listenPayments(String message) throws JsonProcessingException {
        logger.info("message from SQS Queue {}",message);
        ObjectMapper objectMapper = new ObjectMapper();
        SNSDto snsDto = objectMapper.readValue(message, SNSDto.class);
        PaymentCompleteDto paymentCompleteDto = objectMapper.readValue(snsDto.Message, PaymentCompleteDto.class);
        TicketSyncCommand command = new TicketSyncCommand(paymentCompleteDto);
        command.execute(pipeline);
    }
}
