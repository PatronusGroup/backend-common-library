package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime
import java.util.UUID

data class ShipmentStatusUpdatedEvent(

    @JsonProperty("event_type")
    val eventType: ShipmentWebhookEventType,

    @JsonProperty("event_id")
    val eventId: UUID,

    @JsonProperty("timestamp")
    val timestamp: ZonedDateTime,

    @JsonProperty("data")
    val shipmentStatusData: Shipment
)