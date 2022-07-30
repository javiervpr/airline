package builder;

import core.BusinessRuleValidationException;
import java.util.Date;
import model.Passanger;

public class PassangerBuilder {

  private String name = "Javier";
  private String lastname = "Vaca Pereira Roca";
  private Date birthday = new Date();
  private String ci = "912112";
  private boolean needAssistance = false;

  public Passanger build() throws BusinessRuleValidationException {
    return new Passanger(name, lastname, birthday, ci, needAssistance);
  }

  public PassangerBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public PassangerBuilder withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public PassangerBuilder withBirthday(Date birthday) {
    this.birthday = birthday;
    return this;
  }

  public PassangerBuilder withCi(String ci) {
    this.ci = ci;
    return this;
  }

  public PassangerBuilder withNeedAssistance(boolean needAssistance) {
    this.needAssistance = needAssistance;
    return this;
  }
}
