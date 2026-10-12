package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class ShipmentItem(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("merchant_item_id")
    val merchantItemId: String?,

    @JsonProperty("sku")
    val skuId: ShipmentItemSku,

    @JsonProperty("quantity")
    val quantity: Int,

    @JsonProperty("serial_numbers")
    val serialNumbers: List<SerialNumber> = emptyList()
)

data class SerialNumber(

    @JsonProperty("serial_number")
    val serialNumber: String
)

data class ShipmentItemSku(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("sku_code")
    val skuCode: String
)
