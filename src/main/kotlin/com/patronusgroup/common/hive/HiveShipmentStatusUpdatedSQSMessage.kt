package com.patronusgroup.common.hive

import com.patronusgroup.common.hive.api.Shipment
import com.patronusgroup.common.hive.api.ShipmentWebhookEventType
import java.time.ZonedDateTime
import java.util.UUID

data class HiveShipmentStatusUpdatedSQSMessage(
    val eventType: ShipmentWebhookEventType,
    val eventId: UUID,
    val timestamp: ZonedDateTime,
    val shipmentStatusData: Shipment
) : HiveIntegrationSQSMessage() {

    override val type = HiveIntegrationSQSMessageType.SHIPMENT_STATUS_UPDATED
    override val messageDeduplicationId = eventId.toString()
}