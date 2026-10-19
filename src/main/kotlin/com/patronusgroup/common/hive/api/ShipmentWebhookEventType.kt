package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

enum class ShipmentWebhookEventType {

    @JsonProperty("shipment.status_updated")
    SHIPMENT_STATUS_UPDATED,

    @JsonProperty("shipment.delivery_status_updated")
    SHIPMENT_DELIVERY_STATUS_UPDATED;
}
