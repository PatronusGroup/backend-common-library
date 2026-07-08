package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.CareLevel
import com.patronusgroup.common.domain.enum.InsuranceType
import com.patronusgroup.common.domain.enum.Mode

data class Insurance(
    val insuranceType: InsuranceType? = null,
    val careLevel: CareLevel? = null,
    val holderLivesAlone: Boolean? = null,
    val subscriptionToOtherEmergencyDevice: Boolean? = null,
    val provider: String? = null,
    val institutionNumber: String? = null,
    val number: String? = null,
    val selfInsured: Boolean? = null,
    val coInsuredBy: String? = null,
    val mode: Mode? = null,
    val isCareLevelPresent: Boolean
)