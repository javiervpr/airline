package dtos;

import value.objects.SeatCodeValue;

public class SeatDto {

    private String code;
    private String type;
    private String status;

    public SeatDto(String code, String type, String status) {
        this.code = code;
        this.type = type;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
