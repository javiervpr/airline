package dtos;

import java.util.Date;

public class PassangerDto {

    private String name;
    private String lastname;
    private Date birthday;
    private String ci;
    private boolean needAssistance;

    public PassangerDto(String name, String lastname, Date birthday, String ci, boolean needAssistance) {
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.ci = ci;
        this.needAssistance = needAssistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public boolean isNeedAssistance() {
        return needAssistance;
    }

    public void setNeedAssistance(boolean needAssistance) {
        this.needAssistance = needAssistance;
    }
}
