package com.example2.membership;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
class MembershipRequestTranslator {
    Membership translate(CreateMembershipRequest createMembershipRequest) {
        if (createMembershipRequest.getBirthDate() == null) {
            throw new RuntimeException("birthDate cannot be empty");
        }

        if (createMembershipRequest.getEmail() == null) {
            throw new RuntimeException("email cannot be empty");
        }

        if (createMembershipRequest.getMemberName() == null) {
            throw new RuntimeException("memberName cannot be empty");
        }

        if (createMembershipRequest.getMembershipEndDate() == null) {
            throw new RuntimeException("membershipEndDate cannot be empty");
        }

        if (createMembershipRequest.getMembershipStartDate() == null) {
            throw new RuntimeException("membershipStartDate cannot be empty");
        }

        return new Membership(
                createMembershipRequest.getMemberName(),
                stringToDate(createMembershipRequest.getBirthDate()),
                createMembershipRequest.getEmail(),
                new DateRange(
                        stringToDate(createMembershipRequest.getMembershipStartDate()).getTime(),
                        stringToDate(createMembershipRequest.getMembershipEndDate()).getTime()
                )
        );
    }

    private Date stringToDate(String stringDate) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return df.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }
}
