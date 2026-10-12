package com.patronusgroup.common.hive

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.hive.HiveIntegrationSQSMessage.HiveIntegrationSQSMessageTypeStringValue.ORDER_CREATION

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(HiveCreateOrderSQSMessage::class, name = ORDER_CREATION)
)
sealed class HiveIntegrationSQSMessage {

    @get:JsonIgnore
    abstract val type: HiveIntegrationSQSMessageType
    abstract val messageDeduplicationId: String

    object HiveIntegrationSQSMessageTypeStringValue {
        const val ORDER_CREATION = "ORDER_CREATION"
    }

    enum class HiveIntegrationSQSMessageType {
        ORDER_CREATION
    }
}