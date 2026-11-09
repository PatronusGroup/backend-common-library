package com.patronusgroup.common.emergencyCenter

data class EmergencyCenterFailoverView(
    val emergencyCenterId: Int,
    val emergencyCenterName: EmergencyCenterEnum,
    val emergencyCenterStatus: String,
    val isDefault: Boolean,
    var healthStatus: EmergencyCenterHealthStatus,
    val redirectedToEcc: String? = null,
    val customerCount: Int
)