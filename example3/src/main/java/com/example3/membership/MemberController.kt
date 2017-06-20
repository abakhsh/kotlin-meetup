package com.example3.membership

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
open class MemberController(
        private val membershipRepository: MembershipRepository,
        private val membershipRequestTranslator: MembershipRequestTranslator
) {

    @PostMapping("/membership")
    fun createMembership(@RequestBody createMembershipRequest: CreateMembershipRequest): String {
        val membership = membershipRequestTranslator.translate(createMembershipRequest)
        membershipRepository.save(membership)
        return "saved " + membership
    }
}

/*
POST /membership
{
	"memberName": "Jackson Smith",
	"birthDate": "10/29/1994",
	"email": "email@example.com",
	"membershipStartDate": "6/10/2017",
	"membershipEndDate": "6/12/2017"
}
*/