package dtos;

public class SeatDto {

  public String code;
  public String type;
  public String status;
  public String rowColumn;

  public SeatDto() {}

  public SeatDto(String code, String type, String status) {
    this.code = code;
    this.type = type;
    this.status = status;
  }

  public SeatDto(String code, String type, String status, String rowColumn) {
    this.code = code;
    this.type = type;
    this.status = status;
    this.rowColumn = rowColumn;
  }
}
