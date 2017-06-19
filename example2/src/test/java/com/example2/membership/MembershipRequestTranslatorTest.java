package com.example2.membership;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class MembershipRequestTranslatorTest {

    @Test
    public void testTranslate_translatesMembershipRequestDateRange() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setMembershipStartDate("6/10/2017");
        createMembershipRequest.setMembershipEndDate("7/28/2017");

        Membership translatedMembership = membershipRequestTranslator.translate(createMembershipRequest);

        assertThat(translatedMembership.getActiveDateRange().getEpochStart()).isEqualTo(1497070800000L);
        assertThat(translatedMembership.getActiveDateRange().getEpochEnd()).isEqualTo(1501218000000L);
    }

    @Test
    public void testTranslate_translatesMemberBirthDate() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setBirthDate("10/29/1994");

        Membership translatedMembership = membershipRequestTranslator.translate(createMembershipRequest);

        assertThat(translatedMembership.getBirthDate().getTime()).isEqualTo(783406800000L);
    }

    @Test
    public void testTranslate_translateEmail() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setEmail("email@email.com");

        Membership translatedMembership = membershipRequestTranslator.translate(createMembershipRequest);

        assertThat(translatedMembership.getEmail()).isEqualTo("email@email.com");
    }

    @Test
    public void testTranslate_translatesName() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setMemberName("jackson smith");

        Membership translatedMembership = membershipRequestTranslator.translate(createMembershipRequest);

        assertThat(translatedMembership.getMemberName()).isEqualTo("jackson smith");
    }

    @Test
    public void testTranslate_throwsErrorsWhenMemberNameIsNull() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setMemberName(null);

        Throwable throwable = catchThrowable(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                membershipRequestTranslator.translate(createMembershipRequest);
            }
        });

        assertThat(throwable.getMessage()).isEqualTo("memberName cannot be empty");
    }

    @Test
    public void testTranslate_throwsErrorsWhenEmailIsNull() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setEmail(null);

        Throwable throwable = catchThrowable(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                membershipRequestTranslator.translate(createMembershipRequest);
            }
        });

        assertThat(throwable.getMessage()).isEqualTo("email cannot be empty");
    }

    @Test
    public void testTranslate_throwsErrorsWhenBirthDateIsNull() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setBirthDate(null);

        Throwable throwable = catchThrowable(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                membershipRequestTranslator.translate(createMembershipRequest);
            }
        });

        assertThat(throwable.getMessage()).isEqualTo("birthDate cannot be empty");
    }

    @Test
    public void testTranslate_throwsErrorsWhenGetMembershipStartDateNull() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setMembershipStartDate(null);

        Throwable throwable = catchThrowable(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                membershipRequestTranslator.translate(createMembershipRequest);
            }
        });

        assertThat(throwable.getMessage()).isEqualTo("membershipStartDate cannot be empty");
    }

    @Test
    public void testTranslate_throwsErrorsWhenGetMembershipEndDateNull() {
        MembershipRequestTranslator membershipRequestTranslator = new MembershipRequestTranslator();

        CreateMembershipRequest createMembershipRequest = getDefaultRequest();
        createMembershipRequest.setMembershipEndDate(null);

        Throwable throwable = catchThrowable(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                membershipRequestTranslator.translate(createMembershipRequest);
            }
        });

        assertThat(throwable.getMessage()).isEqualTo("membershipEndDate cannot be empty");
    }

    private CreateMembershipRequest getDefaultRequest() {
        CreateMembershipRequest createMembershipRequest = new CreateMembershipRequest();
        createMembershipRequest.setMembershipEndDate("11/11/2001");
        createMembershipRequest.setMembershipStartDate("11/11/2001");
        createMembershipRequest.setEmail("");
        createMembershipRequest.setMemberName("");
        createMembershipRequest.setBirthDate("10/10/10");
        return createMembershipRequest;
    }
}