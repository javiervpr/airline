package utils;

import dtos.PassangerDto;
import model.Passanger;

public final class PassangerMapper {

  public static PassangerDto from(Passanger passanger) {
    return new PassangerDto(
      passanger.getId().toString(),
      passanger.getName(),
      passanger.getLastname(),
      passanger.getBirthday(),
      passanger.getCi(),
      passanger.isNeedAssistance()
    );
  }
}
