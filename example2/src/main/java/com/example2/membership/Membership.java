package com.example2.membership;

import java.util.Date;

public class Membership {
    private String memberName;
    private Date birthDate;
    private String email;
    private DateRange activeDateRange;

    public Membership(String memberName, Date birthDate, String email, DateRange activeDateRange) {
        this.memberName = memberName;
        this.birthDate = birthDate;
        this.email = email;
        this.activeDateRange = activeDateRange;
    }

    public String getMemberName() {
        return memberName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public DateRange getActiveDateRange() {
        return activeDateRange;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "memberName='" + memberName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", activeDateRange=" + activeDateRange +
                '}';
    }
}
