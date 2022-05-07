package dtos;


public class SeatDto {

    public String code;
    public String type;
    public String status;

    public SeatDto() {
    }

    public SeatDto(String code, String type, String status) {
        this.code = code;
        this.type = type;
        this.status = status;
    }

}
