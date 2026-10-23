package com.patronusgroup.common.domain.salesforce

enum class SalesforceAssetStatus {
    NEW,
    REGISTERED,
    SET_UP,
    ASSIGNED,
    INACTIVE_RETURN_INITIATED,
    INACTIVE_RETURN_RECEIVED,
    INACTIVE_RESET_TO_FACTORY_SETTINGS,
    INACTIVE_REMAINS_WITH_CUSTOMER,
    DEFECTIVE;
}