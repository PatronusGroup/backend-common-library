package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class OrderResponse(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("merchant_order_id")
    val merchantOrderId: String,

    @JsonProperty("sales_channel_id")
    val salesChannelId: Int,

    @JsonProperty("items")
    val items: List<OrderItem>,

    @JsonProperty("shipping_address")
    val address: Address,

    @JsonProperty("created_at")
    val createdAt: ZonedDateTime,

    @JsonProperty("fulfillment_status")
    val status: FulfillmentStatus
)

enum class FulfillmentStatus {

    @JsonProperty("waiting_for_picking")
    WAITING_FOR_PICKING,

    @JsonProperty("processing")
    PROCESSING,

    @JsonProperty("partially_shipped")
    PARTIALLY_SHIPPED,

    @JsonProperty("shipped")
    SHIPPED,

    @JsonProperty("on_hold")
    ON_HOLD,

    @JsonProperty("payment_pending")
    PAYMENT_PENDING,

    @JsonProperty("cancelled")
    CANCELLED,

    @JsonProperty("ignored")
    IGNORED;

}

