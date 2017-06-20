package com.example3.membership

import org.springframework.stereotype.Component

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

@Component
open class MembershipRequestTranslator {

    fun translate(inObject: CreateMembershipRequest) = Membership(
            memberName = inObject.memberName ?: throw RuntimeException("memberName cannot be empty"),
            birthDate = inObject.birthDate?.toDate() ?: throw RuntimeException("birthDate cannot be empty"),
            email = inObject.email ?: throw RuntimeException("email cannot be empty"),
            activeDateRange = inObject.getActiveDateRange()
    )

    private fun CreateMembershipRequest.getActiveDateRange() = DateRange(
            membershipStartDate?.toDate()?.time ?: throw RuntimeException("membershipStartDate cannot be empty"),
            membershipEndDate?.toDate()?.time ?: throw RuntimeException("membershipEndDate cannot be empty")
    )

    private fun String?.toDate(): Date = try {
        SimpleDateFormat("MM/dd/yyyy").parse(this)
    } catch (e: ParseException) {
        throw RuntimeException("Invalid date format")
    }
}
