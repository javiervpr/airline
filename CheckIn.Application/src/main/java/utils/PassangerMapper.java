package utils;

import dtos.PassangerDto;
import model.Passanger;

import java.util.Date;

public final class PassangerMapper {

  public static PassangerDto from(Passanger passanger) {
    if(passanger == null)
      return new PassangerDto();
    return new PassangerDto(
     passanger.getId() == null ? "" : passanger.getId().toString(),
     passanger.getName() == null ? "" : passanger.getName(),
     passanger.getLastname() == null ? "" : passanger.getLastname(),
     passanger.getBirthday() == null ? new Date() : passanger.getBirthday(),
     passanger.getCi() == null ? "" : passanger.getCi(),
     passanger.isNeedAssistance()
    );
  }
}
