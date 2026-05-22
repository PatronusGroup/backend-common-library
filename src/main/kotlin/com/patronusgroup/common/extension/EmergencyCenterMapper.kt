package com.patronusgroup.common.extension

import com.patronusgroup.common.emergencyCenter.EmergencyCenterEnum
import com.patronusgroup.common.emergencyCenter.SalesforceEmergencyCenterEnum

fun EmergencyCenterEnum.toSalesforceEmergencyCenterEnum(): SalesforceEmergencyCenterEnum {
    return when (this) {
        EmergencyCenterEnum.MD_MEDICUS -> SalesforceEmergencyCenterEnum.MD_MEDICUS
        EmergencyCenterEnum.DRK -> SalesforceEmergencyCenterEnum.DRK
        EmergencyCenterEnum.ASB -> SalesforceEmergencyCenterEnum.ASB
        EmergencyCenterEnum.NON_ECC -> SalesforceEmergencyCenterEnum.NON_ECC
        EmergencyCenterEnum.ASB_KOELN -> SalesforceEmergencyCenterEnum.ASB_KOELN
    }
}

fun SalesforceEmergencyCenterEnum.toEmergencyCenterEnum(): EmergencyCenterEnum {
    return when (this) {
        SalesforceEmergencyCenterEnum.MD_MEDICUS -> EmergencyCenterEnum.MD_MEDICUS
        SalesforceEmergencyCenterEnum.DRK -> EmergencyCenterEnum.DRK
        SalesforceEmergencyCenterEnum.ASB -> EmergencyCenterEnum.ASB
        SalesforceEmergencyCenterEnum.NON_ECC -> EmergencyCenterEnum.NON_ECC
        SalesforceEmergencyCenterEnum.ASB_KOELN -> EmergencyCenterEnum.ASB_KOELN
    }
}