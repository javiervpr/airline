package dtos;

public class BaggageDto {

  public float weight;
  public String type;
  public String checkInId;

  public BaggageDto() {}

  public BaggageDto(float weight, String type, String checkInId) {
    this.weight = weight;
    this.type = type;
  }

  @Override
  public String toString() {
    return (
      "{" +
      "weight:" +
      weight +
      ", type:'" +
      type +
      '\'' +
      ", checkInId:'" +
      checkInId +
      '\'' +
      '}'
    );
  }
}
