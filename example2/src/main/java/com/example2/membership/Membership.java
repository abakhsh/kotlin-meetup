package com.example2.membership;

import java.util.Date;

public class Membership {
    private final String memberName;
    private final Date birthDate;
    private final String email;
    private final DateRange activeDateRange;

    Membership(String memberName, Date birthDate, String email, DateRange activeDateRange) {
        this.memberName = memberName;
        this.birthDate = birthDate;
        this.email = email;
        this.activeDateRange = activeDateRange;
    }

    String getMemberName() {
        return memberName;
    }

    Date getBirthDate() {
        return birthDate;
    }

    String getEmail() {
        return email;
    }

    DateRange getActiveDateRange() {
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
