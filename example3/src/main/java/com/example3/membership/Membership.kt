package com.example3.membership

import java.util.Date

data class Membership(
        val memberName: String,
        val birthDate: Date,
        val email: String,
        val activeDateRange: DateRange
)
