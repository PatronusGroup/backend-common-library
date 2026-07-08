package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.Mode

data class Doctor(
    val name: String?,
    val phoneNumber: String?,
    val mode: Mode?
)