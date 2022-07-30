package builder;

import dtos.BaggageDto;
import java.util.UUID;
import model.BaggageType;

public class BaggageDtoBuilder {

  public float weight = 20;
  public String type = BaggageType.CHECKED_BAG.toString();
  public String checkInId = UUID.randomUUID().toString();

  public BaggageDto build() {
    return new BaggageDto(weight, type, checkInId);
  }

  public BaggageDtoBuilder withWeight(float weight) {
    this.weight = weight;
    return this;
  }

  public BaggageDtoBuilder withType(String type) {
    this.type = type;
    return this;
  }

  public BaggageDtoBuilder withCheckInId(String checkInId) {
    this.checkInId = checkInId;
    return this;
  }
}
