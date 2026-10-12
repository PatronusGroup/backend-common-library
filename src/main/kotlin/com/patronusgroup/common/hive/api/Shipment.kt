package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class Shipment(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("order_id")
    val orderId: Int,

    @JsonProperty("merchant_order_id")
    val merchantOrderId: String,

    @JsonProperty("sales_channel_id")
    val salesChannelId: Int,

    @JsonProperty("status")
    val status: ShipmentStatus,

    @JsonProperty("delivery_status")
    val deliveryStatus: ShipmentDeliveryStatus?,

    @JsonProperty("shipment_provider")
    val shipmentProvider: String?,

    @JsonProperty("shipping_method")
    val shippingMethod: String?,

    @JsonProperty("tracking_number")
    val trackingNumber: String?,

    @JsonProperty("tracking_url")
    val trackingUrl: String?,

    @JsonProperty("created_at")
    val createdAt: ZonedDateTime?,

    @JsonProperty("updated_at")
    val updatedAt: ZonedDateTime?,

    @JsonProperty("delivered_at")
    val deliveredAt: ZonedDateTime?,

    @JsonProperty("items")
    val items: List<ShipmentItem>
)