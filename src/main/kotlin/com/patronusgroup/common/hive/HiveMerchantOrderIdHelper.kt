package com.patronusgroup.common.hive

object HiveMerchantOrderIdHelper {

    const val MERCHANT_ORDER_ID_DELIMITER = "_"

    fun createHiveMerchantOrderId(orderNumber: String, deviceOrdinalNumber: String): String {
        return "$orderNumber$MERCHANT_ORDER_ID_DELIMITER$deviceOrdinalNumber"
    }

    fun extractSalesforceOrderNumber(hiveMerchantOrderId: String): String {
        return hiveMerchantOrderId.split(MERCHANT_ORDER_ID_DELIMITER).first()
    }
}