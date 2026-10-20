package com.patronusgroup.common.hive

import com.patronusgroup.common.hive.api.Shipment
import com.patronusgroup.common.hive.api.ShipmentWebhookEventType
import java.time.ZonedDateTime
import java.util.UUID

data class HiveShipmentDeliveryStatusUpdatedSQSMessage(
    val eventId: UUID,
    val timestamp: ZonedDateTime,
    val shipmentStatusData: Shipment
) : AbstractHiveShipmentUpdateSQSMessage() {

    override val type = HiveIntegrationSQSMessageType.SHIPMENT_DELIVERY_STATUS_UPDATED
    override val messageDeduplicationId = eventId.toString()
    override val eventType = ShipmentWebhookEventType.SHIPMENT_DELIVERY_STATUS_UPDATED
}