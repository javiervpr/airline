package builder;

import dtos.SeatDto;
import java.util.UUID;
import model.SeatStatus;
import model.SeatType;

public class SeatDtoBuilder {

  public String code = UUID.randomUUID().toString();
  public String type = SeatType.ECONOMY.toString();
  public String status = SeatStatus.FREE.toString();

  public SeatDto build() {
    return new SeatDto(code, type, status);
  }

  public SeatDtoBuilder withCode(String code) {
    this.code = code;
    return this;
  }

  public SeatDtoBuilder withType(String type) {
    this.type = type;
    return this;
  }

  public SeatDtoBuilder withStatus(String status) {
    this.status = status;
    return this;
  }
}
