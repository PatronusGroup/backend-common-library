package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.Mode

data class EmergencyContacts(
    val mode: Mode?,
    val contacts: List<EmergencyContact>
)