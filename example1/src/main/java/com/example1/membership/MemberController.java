package com.example1.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MembershipRepository membershipRepository;

    @Autowired
    MemberController(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @PostMapping("/membership")
    public String createMembership(@RequestBody Membership membership) {
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