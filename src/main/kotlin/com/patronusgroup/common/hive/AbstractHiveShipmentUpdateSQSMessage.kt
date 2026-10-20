package com.patronusgroup.common.hive

import com.patronusgroup.common.hive.api.ShipmentWebhookEventType

abstract class AbstractHiveShipmentUpdateSQSMessage : HiveIntegrationSQSMessage() {

    abstract val eventType: ShipmentWebhookEventType
}