package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.DataSyncSQSMessageTypeStringValue.HOLDER_ADDRESS_UPDATE
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.DataSyncSQSMessageTypeStringValue.HOLDER_BIRTHDAY_UPDATE
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.DataSyncSQSMessageTypeStringValue.HOLDER_PHONE_NUMBER_UPDATE

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(HolderAddressUpdateSQSMessage::class, name = HOLDER_ADDRESS_UPDATE),
    JsonSubTypes.Type(HolderAddressUpdateSQSMessage::class, name = HOLDER_BIRTHDAY_UPDATE),
    JsonSubTypes.Type(HolderAddressUpdateSQSMessage::class, name = HOLDER_PHONE_NUMBER_UPDATE)
)
sealed class DataSyncSQSMessage {

    abstract val type: DataSyncSQSMessageType

    object DataSyncSQSMessageTypeStringValue {
        const val HOLDER_ADDRESS_UPDATE = "HOLDER_ADDRESS_UPDATE"
        const val HOLDER_BIRTHDAY_UPDATE = "HOLDER_BIRTHDAY_UPDATE"
        const val HOLDER_PHONE_NUMBER_UPDATE = "HOLDER_PHONE_NUMBER_UPDATE"
    }

    enum class DataSyncSQSMessageType {
        HOLDER_ADDRESS_UPDATE,
        HOLDER_BIRTHDAY_UPDATE,
        HOLDER_PHONE_NUMBER_UPDATE
    }

    object ObjectKeyTypeStringValue {
        const val SALESFORCE = "SALESFORCE"
        const val DYNAMO_DB = "DYNAMO_DB"
        const val POSTGRES_DB = "POSTGRES_DB"
    }

    enum class ObjectKeyType(val systemDisplayName: String) {
        SALESFORCE("Salesforce"),
        DYNAMO_DB("Customer Portal"),
        POSTGRES_DB("Backoffice")
    }
}