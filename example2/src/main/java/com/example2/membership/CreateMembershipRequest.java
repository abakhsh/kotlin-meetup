package com.example2.membership;

class CreateMembershipRequest {
    private String memberName;
    private String birthDate;
    private String email;
    private String membershipStartDate;
    private String membershipEndDate;

    String getMemberName() {
        return memberName;
    }

    void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    String getBirthDate() {
        return birthDate;
    }

    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getMembershipStartDate() {
        return membershipStartDate;
    }

    void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    String getMembershipEndDate() {
        return membershipEndDate;
    }

    void setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }
}
