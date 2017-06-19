package com.example1.membership;

import org.springframework.stereotype.Component;

@Component
public class MembershipRepository {
    void save(Membership membership) {
        System.out.println("saving membership: " + membership);
    }
}
