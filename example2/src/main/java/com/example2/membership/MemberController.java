package com.example2.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MembershipRepository membershipRepository;
    private MembershipRequestTranslator membershipRequestTranslator;

    @Autowired
    MemberController(MembershipRepository membershipRepository, MembershipRequestTranslator membershipRequestTranslator) {
        this.membershipRepository = membershipRepository;
        this.membershipRequestTranslator = membershipRequestTranslator;
    }

    @PostMapping("/membership")
    public String createMembership(@RequestBody CreateMembershipRequest createMembershipRequest) {
        Membership membership = membershipRequestTranslator.translate(createMembershipRequest);
        membershipRepository.save(membership);
        return "saved " + membership;
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