package com.patronusgroup.common.hive

import com.patronusgroup.common.hive.api.OrderRequest

data class HiveCreateOrderSQSMessage(
    val createOrderRequest: OrderRequest
) : HiveIntegrationSQSMessage() {

    override val type = HiveIntegrationSQSMessageType.ORDER_CREATION
}