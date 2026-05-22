package com.patronusgroup.common.emergencyCenter

import com.patronusgroup.common.exception.NotSupportedException

enum class SalesforceEmergencyCenterEnum(val salesforceValue: String) {
    MD_MEDICUS("MDMedicus"),
    DRK("DRK"),
    ASB("ASB"),
    NON_ECC("NON ECC"),
    ASB_KOELN("ASB Koeln");

    companion object {

        fun fromSalesforceValue(salesforceValue: String): SalesforceEmergencyCenterEnum {
            for (emergencyCenter in entries) {
                if (emergencyCenter.salesforceValue == salesforceValue) {
                    return emergencyCenter
                }
            }
            throw NotSupportedException("Emergency center not supported!")
        }
    }
}