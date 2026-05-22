package com.patronusgroup.common.emergencyCenter

import com.patronusgroup.common.exception.NotSupportedException

enum class EmergencyCenterEnum(val databaseValue: String) {
    MD_MEDICUS("MD_MEDICUS"),
    DRK("DRK"),
    ASB("ASB"),
    NON_ECC("NON_ECC"),
    ASB_KOELN("ASB_KOELN");

    companion object {

        fun fromDatabaseValue(databaseValue: String): EmergencyCenterEnum {
            for (emergencyCenter in EmergencyCenterEnum.entries) {
                if (emergencyCenter.databaseValue == databaseValue) {
                    return emergencyCenter
                }
            }
            throw NotSupportedException("Emergency center $databaseValue is not supported!")
        }
    }
}