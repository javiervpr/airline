package dtos;

import java.util.Date;

public class PassangerDto {

    public String id;
    public String name;
    public String lastname;
    public Date birthday;
    public String ci;
    public boolean needAssistance;

    public PassangerDto() {
    }

    public PassangerDto(String id, String name, String lastname, Date birthday, String ci, boolean needAssistance) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.ci = ci;
        this.needAssistance = needAssistance;
    }
}
