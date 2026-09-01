package com.patronusgroup.common.domain.healthData.keyDeposit

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class HealthDataKeyDeposit(
    val keyDepositRecordType: KeyDepositRecordType = KeyDepositRecordType.NONE,
    val nursingServiceName: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val street: String? = null,
    val keyDepositDescription: String? = null
)