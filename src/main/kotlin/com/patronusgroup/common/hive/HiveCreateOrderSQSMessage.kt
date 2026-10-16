package com.patronusgroup.common.hive

import com.patronusgroup.common.hive.api.Address
import com.patronusgroup.common.hive.api.OrderItem

data class HiveCreateOrderSQSMessage(
    val merchantOrderId: String,
    val items: List<OrderItem>,
    val address: Address,
    val currency: String = "EUR"
) : HiveIntegrationSQSMessage() {

    override val type = HiveIntegrationSQSMessageType.ORDER_CREATION
}