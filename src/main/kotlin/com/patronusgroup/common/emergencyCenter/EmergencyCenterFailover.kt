package com.patronusgroup.common.emergencyCenter

import java.time.Instant
import java.util.UUID

data class EmergencyCenterFailover(
    val id: UUID,
    val sourceEmergencyCenter: EmergencyCenter,
    val targetEmergencyCenter: EmergencyCenter,
    val active: Boolean,
    val reason : String,
    val startedAt: Instant,
    val startedBy: String,
    var endedAt: Instant? = null,
    var endedBy: String? = null
) {

    enum class SortBy(val value: String) {
        STARTED_AT("startedAt"),
    }
}