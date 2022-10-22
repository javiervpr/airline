package controllers;


import an.awesome.pipelinr.Pipeline;
import dtos.SeatDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import use.cases.command.checkin.seats.GetSeatsByFlightQuery;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SeatController {

    Logger logger = LoggerFactory.getLogger(SeatController.class);
    final Pipeline pipeline;

    public SeatController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/seats/{flightId}")
    public List<SeatDto> getSeatsByFlightId(@PathVariable String flightId) {
        GetSeatsByFlightQuery query = new GetSeatsByFlightQuery(flightId);
        return query.execute(pipeline);
    }
}
