package dtos;

import java.util.List;

public class FlightData {
    public float id;
    public String created_at;
    public String updated_at;
    public String uuid;
    public String source_airport_code;
    public String destiny_airport_code;
    public String departure_week_days;
    public String flight_program_id;

    public FlightInfo flight;
    public List<FlightProgram> flight_programs;

}
