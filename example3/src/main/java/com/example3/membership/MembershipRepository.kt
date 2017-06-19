package com.example3.membership

import org.springframework.stereotype.Component

@Component
open class MembershipRepository {
    fun save(membership: Membership) {
        println("saving membership: " + membership)
    }
}
