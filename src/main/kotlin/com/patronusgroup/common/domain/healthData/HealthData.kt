package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.FormStatus
import com.patronusgroup.common.domain.healthData.keyDeposit.HealthDataKeyDeposit
import java.time.Instant
import java.util.UUID

data class HealthData(
    val email: String,
    val createdAt: Instant = Instant.now(),
    val formUuid: UUID = UUID.randomUUID(),
    val salesforceHealthDataId: String? = null,
    val updatedAtInternal: Instant? = null,
    val updatedAtExternal: Instant? = null,
    val submittedAtInternal: Instant? = null,
    val submittedAtExternal: Instant? = null,
    val salesforceAccountId: String? = null,
    var personalDetails: PersonalDetails? = null,
    val insurance: Insurance? = null,
    val keyBox: KeyBox? = null,
    val emergencyContacts: EmergencyContacts? = null,
    val medical: Medical? = null,
    val doctor: Doctor? = null,
    val formStatus: FormStatus,
    val utmCampaign: String? = null,
    val utmSource: String? = null,
    val utmMedium: String? = null,
    val trackId: String? = null,
    val chargeBeeCustomerId: String? = null,
    val chargeBeeSubscriptionId: String? = null,
    val submittedBy: String? = null,
    val watchUserId: String? = null,
    val activationCode: String? = null,
    val keyDeposit: HealthDataKeyDeposit? = null,
    val initialWifiInfo: InitialWifiInfo? = null,
    val usingNonEccPlan: Boolean? = null,
    val adviceWanted: Boolean? = null
)