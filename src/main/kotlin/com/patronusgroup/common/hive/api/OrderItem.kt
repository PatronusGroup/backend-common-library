package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class OrderItem(

    @JsonProperty("sku_code")
    val merchantSkuId: String,

    @JsonProperty("merchant_item_id")
    val merchantItemId: String,

    @JsonProperty("price_per_unit_in_cents")
    val pricePerUnitInCents: Int = 0,

    @JsonProperty("quantity")
    val quantity: Int = 1
)
