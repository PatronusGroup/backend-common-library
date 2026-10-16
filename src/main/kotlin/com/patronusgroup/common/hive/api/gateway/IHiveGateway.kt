package com.patronusgroup.common.hive.api.gateway

import com.patronusgroup.common.hive.api.OrderRequest
import com.patronusgroup.common.hive.api.OrderResponse
import com.patronusgroup.common.hive.api.SalesChannelsResponse
import com.patronusgroup.common.hive.api.Shipment

interface IHiveGateway {

    fun createOrder(order: OrderRequest): OrderResponse

    fun getSalesChannels(): SalesChannelsResponse

    fun getShipmentByMerchantOrderId(orderId: String): Shipment?
}