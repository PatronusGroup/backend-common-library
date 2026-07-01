package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.CarerRelationship
import com.patronusgroup.common.domain.enum.Mode
import java.util.UUID

data class EmergencyContact(
    val contactId: String?,
    val contactUuid: UUID? = UUID.randomUUID(),
    val relationship: CarerRelationship?,
    val gender: String?,
    val firstName: String?,
    val lastName: String?,
    val phoneNumbers: List<PhoneNumber>?,
    val giveAccessToCarerApp: Boolean?,
    val hasEmergencyKey: Boolean?,
    val minutes: Int?,
    val mode: Mode?
)