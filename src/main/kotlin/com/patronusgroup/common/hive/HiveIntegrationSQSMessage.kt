package com.patronusgroup.common.hive

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.hive.HiveIntegrationSQSMessage.HiveIntegrationSQSMessageTypeStringValue.ORDER_CREATION
import com.patronusgroup.common.hive.HiveIntegrationSQSMessage.HiveIntegrationSQSMessageTypeStringValue.SHIPMENT_DELIVERY_STATUS_UPDATED
import com.patronusgroup.common.hive.HiveIntegrationSQSMessage.HiveIntegrationSQSMessageTypeStringValue.SHIPMENT_STATUS_UPDATED

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(HiveCreateOrderSQSMessage::class, name = ORDER_CREATION),
        JsonSubTypes.Type(HiveShipmentStatusUpdatedSQSMessage::class, name = SHIPMENT_STATUS_UPDATED),
        JsonSubTypes.Type(HiveShipmentDeliveryStatusUpdatedSQSMessage::class, name = SHIPMENT_DELIVERY_STATUS_UPDATED)
)
sealed class HiveIntegrationSQSMessage {

    @get:JsonIgnore
    abstract val type: HiveIntegrationSQSMessageType
    abstract val messageDeduplicationId: String

    object HiveIntegrationSQSMessageTypeStringValue {
        const val ORDER_CREATION = "ORDER_CREATION"
        const val SHIPMENT_STATUS_UPDATED = "SHIPMENT_STATUS_UPDATED"
        const val SHIPMENT_DELIVERY_STATUS_UPDATED = "SHIPMENT_DELIVERY_STATUS_UPDATED"
    }

    enum class HiveIntegrationSQSMessageType {
        ORDER_CREATION,
        SHIPMENT_STATUS_UPDATED,
        SHIPMENT_DELIVERY_STATUS_UPDATED
    }
}