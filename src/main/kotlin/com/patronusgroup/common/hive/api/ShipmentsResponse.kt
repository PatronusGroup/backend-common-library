package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class ShipmentsResponse(
    @JsonProperty("data")
    val shipments: List<Shipment> = emptyList()
)
