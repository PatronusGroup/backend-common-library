package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class OrderRequest(

    @JsonProperty("merchant_order_id")
    val merchantOrderId: String,

    @JsonProperty("items")
    val items: List<OrderItem>,

    @JsonProperty("shipping_address")
    val address: Address,

    @JsonProperty("sales_channel_id")
    val salesChannelId: Int,

    @JsonProperty("currency")
    val currency: String = "EUR"
)
