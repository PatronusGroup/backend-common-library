package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

enum class ShipmentDeliveryStatus {

    @JsonProperty("action_required")
    ACTION_REQUIRED,

    @JsonProperty("awaiting_customer_pickup")
    AWAITING_CUSTOMER_PICKUP,

    @JsonProperty("delivered")
    DELIVERED,

    @JsonProperty("in_transit")
    IN_TRANSIT,

    @JsonProperty("information_transmitted")
    INFORMATION_TRANSMITTED,

    @JsonProperty("other")
    OTHER,

    @JsonProperty("out_for_delivery")
    OUT_FOR_DELIVERY,

    @JsonProperty("return_initiated")
    RETURN_INITIATED,

    @JsonProperty("returned_to_sender")
    RETURNED_TO_SENDER
}