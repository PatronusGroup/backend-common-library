package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

enum class ShipmentStatus {

    @JsonProperty("cancelled")
    CANCELLED,

    @JsonProperty("in_packing")
    IN_PACKING,

    @JsonProperty("in_picking")
    IN_PICKING,

    @JsonProperty("in_shipping")
    IN_SHIPPING,

    @JsonProperty("on_hold")
    ON_HOLD,

    @JsonProperty("packed")
    PACKED,

    @JsonProperty("picked")
    PICKED,

    @JsonProperty("picking_assigned")
    PICKING_ASSIGNED,

    @JsonProperty("shipped")
    SHIPPED,

    @JsonProperty("waiting_for_picking")
    WAITING_FOR_PICKING;
}
