package builder;

import dtos.PassangerDto;
import java.util.Date;
import java.util.UUID;

public class PassangerDtoBuilder {

  public String id = UUID.randomUUID().toString();
  public String name = "Javier";
  public String lastname = "Vaca Pereira Roca";
  public Date birthday = new Date();
  public String ci = "912112";
  public boolean needAssistance = false;

  public PassangerDto build() {
    return new PassangerDto(id, name, lastname, birthday, ci, needAssistance);
  }

  public PassangerDtoBuilder withId(String id) {
    this.id = id;
    return this;
  }

  public PassangerDtoBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public PassangerDtoBuilder withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public PassangerDtoBuilder withBirthday(Date birthday) {
    this.birthday = birthday;
    return this;
  }

  public PassangerDtoBuilder withCi(String ci) {
    this.ci = ci;
    return this;
  }

  public PassangerDtoBuilder withNeedAssistance(boolean needAssistance) {
    this.needAssistance = needAssistance;
    return this;
  }
}
