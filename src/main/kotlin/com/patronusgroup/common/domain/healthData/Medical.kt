package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.BloodGroup
import com.patronusgroup.common.domain.enum.Mode

data class Medical(
    val bloodGroup: BloodGroup?,
    val currentIllnesses: String?,
    val currentMedication: String?,
    val currentAllergies: String?,
    val mode: Mode?
)