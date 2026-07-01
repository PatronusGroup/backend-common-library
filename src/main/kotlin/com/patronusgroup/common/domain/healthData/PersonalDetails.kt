package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.Gender
import com.patronusgroup.common.domain.enum.Mode

data class PersonalDetails(
    val gender: Gender? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val dateOfBirth: String? = null,
    var street: String? = null,
    var zipCode: String? = null,
    var city: String? = null,
    val mode: Mode? = null,
    val phoneNumber: String? = null
)