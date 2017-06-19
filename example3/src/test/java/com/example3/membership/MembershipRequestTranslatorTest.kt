package com.example3.membership

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable

class MembershipRequestTranslatorTest {

    @Test
    fun testTranslate_translatesMembershipRequestDateRange() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.membershipStartDate = "6/10/2017"
        createMembershipRequest.membershipEndDate = "7/28/2017"

        val translatedMembership = membershipRequestTranslator.translate(createMembershipRequest)

        assertThat(translatedMembership.activeDateRange.epochStart).isEqualTo(1497070800000L)
        assertThat(translatedMembership.activeDateRange.epochEnd).isEqualTo(1501218000000L)
    }

    @Test
    fun testTranslate_translatesMemberBirthDate() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.birthDate = "10/29/1994"

        val translatedMembership = membershipRequestTranslator.translate(createMembershipRequest)

        assertThat(translatedMembership.birthDate.time).isEqualTo(783406800000L)
    }

    @Test
    fun testTranslate_translateEmail() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.email = "email@email.com"

        val translatedMembership = membershipRequestTranslator.translate(createMembershipRequest)

        assertThat(translatedMembership.email).isEqualTo("email@email.com")
    }

    @Test
    fun testTranslate_translatesName() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.memberName = "jackson smith"

        val translatedMembership = membershipRequestTranslator.translate(createMembershipRequest)

        assertThat(translatedMembership.memberName).isEqualTo("jackson smith")
    }

    @Test
    fun testTranslate_throwsErrorsWhenMemberNameIsNull() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.memberName = null

        val throwable = catchThrowable { membershipRequestTranslator.translate(createMembershipRequest) }

        assertThat(throwable.message).isEqualTo("memberName cannot be empty")
    }

    @Test
    fun testTranslate_throwsErrorsWhenEmailIsNull() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.email = null

        val throwable = catchThrowable { membershipRequestTranslator.translate(createMembershipRequest) }

        assertThat(throwable.message).isEqualTo("email cannot be empty")
    }

    @Test
    fun testTranslate_throwsErrorsWhenBirthDateIsNull() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.birthDate = null

        val throwable = catchThrowable { membershipRequestTranslator.translate(createMembershipRequest) }

        assertThat(throwable.message).isEqualTo("birthDate cannot be empty")
    }

    @Test
    fun testTranslate_throwsErrorsWhenGetMembershipStartDateNull() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.membershipStartDate = null

        val throwable = catchThrowable { membershipRequestTranslator.translate(createMembershipRequest) }

        assertThat(throwable.message).isEqualTo("membershipStartDate cannot be empty")
    }

    @Test
    fun testTranslate_throwsErrorsWhenGetMembershipEndDateNull() {
        val membershipRequestTranslator = MembershipRequestTranslator()

        val createMembershipRequest = defaultRequest
        createMembershipRequest.membershipEndDate = null

        val throwable = catchThrowable { membershipRequestTranslator.translate(createMembershipRequest) }

        assertThat(throwable.message).isEqualTo("membershipEndDate cannot be empty")
    }

    private val defaultRequest = CreateMembershipRequest().apply {
            membershipEndDate = "11/11/2001"
            membershipStartDate = "11/11/2001"
            email = ""
            memberName = ""
            birthDate = "10/10/10"
        }
}