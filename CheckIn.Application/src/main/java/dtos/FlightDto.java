package dtos;

import java.util.List;

public class FlightDto {
    public String event;
    public FlightData data;
}

class FlightProgram {
    public int id;
    public String source_airport_code;
    public String destiny_airport_code;
    public String uuid;
    public String updated_at;
    public String created_at;
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