package com.patronusgroup.common.emergencyCenter

data class EmergencyCenter(
    val emergencyCenterId: Int,
    val emergencyCenterName: String,
    val emergencyCenterStatusId: Int,
    val isDefault: Boolean
) {
    enum class EmergencyCenterStatus(val databaseId: Int) {
        ACTIVE(1),
        INACTIVE(2);
    }
}