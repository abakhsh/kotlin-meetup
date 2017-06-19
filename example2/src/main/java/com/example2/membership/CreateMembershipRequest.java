package com.example2.membership;

public class CreateMembershipRequest {
    private String memberName;
    private String birthDate;
    private String email;
    private String membershipStartDate;
    private String membershipEndDate;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }
}

