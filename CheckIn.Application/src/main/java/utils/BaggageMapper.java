package utils;

import core.BusinessRuleValidationException;
import dtos.BaggageDto;
import java.util.UUID;
import model.Baggage;

public final class BaggageMapper {

  public static BaggageDto from(Baggage baggage) {
    if (baggage == null) return new BaggageDto();
    return new BaggageDto(
      baggage.getWeight(),
      baggage.getType().toString(),
      baggage.getCheckInId().toString()
    );
  }

  public static Baggage from(BaggageDto baggageDto)
    throws BusinessRuleValidationException {
    return new Baggage(
      baggageDto.weight,
      UUID.fromString(baggageDto.checkInId)
    );
  }
}
