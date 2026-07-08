package com.patronusgroup.common.domain.healthData.keyDeposit

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.UUID

@JsonInclude(JsonInclude.Include.NON_NULL)
data class HealthDataKeyDeposit(
    val uuid: UUID? = null,
    val keyDepositSalesforceId: String? = null,
    val keyDepositReferenceId: String? = null,
    val keyDepositRecordType: KeyDepositRecordType? = null,
    val keyDepositName: String? = null,
    val nursingServiceName: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val street: String? = null,
    val keyBoxCode: String? = null,
    val keyBoxLocation: String? = null,
    val additionalInformation: String? = null
)