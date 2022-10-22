package controllers;


import an.awesome.pipelinr.Pipeline;
import dtos.PassangerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.passenger.get.passenger.pay.complete.PassengerPayCompleteQuery;
import use.cases.command.passenger.get.passengers.GetPassengersQuery;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PassengerController {

    Logger logger = LoggerFactory.getLogger(PassengerController.class);
    final Pipeline pipeline;

    public PassengerController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/passenger")
    public List<PassangerDto> getPassengers() {
        GetPassengersQuery query = new GetPassengersQuery();
        return query.execute(pipeline);
    }

    @GetMapping("/passenger-pay-complete/{flightId}")
    public List<PassangerDto> getPassengersPayCompleted(@PathVariable String flightId) {
        PassengerPayCompleteQuery query = new PassengerPayCompleteQuery(flightId);
        return query.execute(pipeline);
    }
}
