package dtos;

import java.util.List;

public class FlightDto {
    public String event;
    public FlightData data;
}

class FlightProgramDto {
    public int id;
    public String created_at;
    public String updated_at;
    public String uuid;
    public String sourceAirport;
    public String destinyAirport;
    public String flightCode;
    public int itinerary_id;
}

class Aircraft {
    public String brand;
    public String model;
    public String state;
    public float loadCapacity;
    public float seatNumber;
    public float tankCapacity;
    public String parkingAirport;
    public String uuid;
}

class Crew {
    public String id;
    public List<Worker> workers;
}

class Worker {
    public String name;
    public String role;
}