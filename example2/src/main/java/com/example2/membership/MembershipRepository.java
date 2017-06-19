package com.example2.membership;

import org.springframework.stereotype.Component;

@Component
class MembershipRepository {
    void save(Membership membership) {
        System.out.println("saving membership: " + membership);
    }
}
