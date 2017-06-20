package com.example3.membership

data class CreateMembershipRequest(
    var memberName: String? = null,
    var birthDate: String? = null,
    var email: String? = null,
    var membershipStartDate: String? = null,
    var membershipEndDate: String? = null
)

