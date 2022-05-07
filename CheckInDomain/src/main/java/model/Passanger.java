package model;

import core.BusinessRuleValidationException;
import core.Entity;
import value.objects.CIValue;
import value.objects.PersonNameValue;

import java.util.Date;
import java.util.UUID;

public class Passanger extends Entity {

    private PersonNameValue name;
    private PersonNameValue lastname;
    private Date birthday;
    private CIValue ci;
    private boolean needAssistance;

    public Passanger(String name, String lastname, Date birthday, String ci, boolean needAssistance) throws BusinessRuleValidationException {
        this.id = UUID.randomUUID();
        this.name = new PersonNameValue(name);
        this.lastname = new PersonNameValue(lastname);
        this.birthday = birthday;
        this.ci = new CIValue(ci);
        this.needAssistance = needAssistance;
    }

    public Passanger(UUID id, String name, String lastname, Date birthday, String ci, boolean needAssistance) throws BusinessRuleValidationException {
        this.id = id;
        this.name = new PersonNameValue(name);
        this.lastname = new PersonNameValue(lastname);
        this.birthday = birthday;
        this.ci = new CIValue(ci);
        this.needAssistance = needAssistance;
    }

    public String getName() {
        return name.getName();
    }

    public String getLastname() {
        return lastname.getName();
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCi() {
        return ci.getCi();
    }

    public boolean isNeedAssistance() {
        return needAssistance;
    }
}
