package use.cases.command.passenger;

import an.awesome.pipelinr.Command;
import dtos.PassengerSyncDto;

import java.util.UUID;

public class PassengerSyncCommand implements Command<UUID> {

    PassengerSyncDto passengerSyncDto;

    public PassengerSyncCommand(PassengerSyncDto passengerSyncDto) {
        this.passengerSyncDto = passengerSyncDto;
    }
}
