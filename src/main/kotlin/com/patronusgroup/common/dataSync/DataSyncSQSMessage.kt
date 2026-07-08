package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.DataSyncSQSMessageTypeStringValue.HOLDER_ADDRESS_UPDATE
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.HolderAddressUpdateSQSMessage.HolderAddressUpdateObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.HolderAddressUpdateSQSMessage.HolderAddressUpdateObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.HolderAddressUpdateSQSMessage.HolderAddressUpdateObjectKeyTypeStringValue.SALESFORCE
import java.util.UUID

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(DataSyncSQSMessage.HolderAddressUpdateSQSMessage::class, name = HOLDER_ADDRESS_UPDATE),
)
sealed class DataSyncSQSMessage {

    abstract val type: DataSyncSQSMessageType

    object DataSyncSQSMessageTypeStringValue {
        const val HOLDER_ADDRESS_UPDATE = "HOLDER_ADDRESS_UPDATE"
    }

    enum class DataSyncSQSMessageType {
        HOLDER_ADDRESS_UPDATE
    }

    data class HolderAddressUpdateSQSMessage(
        val objectKey: HolderAddressUpdateObjectKey,
        val city: String,
        val zipCode: String,
        val street: String

    ) : DataSyncSQSMessage() {

        override val type = DataSyncSQSMessageType.HOLDER_ADDRESS_UPDATE

        @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type"
        )
        @JsonSubTypes(
            JsonSubTypes.Type(HolderAddressUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
            JsonSubTypes.Type(HolderAddressUpdateObjectKey.DynamoDbKey::class, name = DYNAMO_DB),
            JsonSubTypes.Type(HolderAddressUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
        )
        sealed class HolderAddressUpdateObjectKey {
            abstract val type: HolderAddressUpdateObjectKeyType

            data class SalesforceKey(val formUuid: UUID) : HolderAddressUpdateObjectKey() {
                override val type = HolderAddressUpdateObjectKeyType.SALESFORCE
            }

            data class DynamoDbKey(val formUuid: UUID) : HolderAddressUpdateObjectKey() {
                override val type = HolderAddressUpdateObjectKeyType.DYNAMO_DB
            }

            data class PostgresDbKey(val watchUserId: String) : HolderAddressUpdateObjectKey() {
                override val type = HolderAddressUpdateObjectKeyType.POSTGRES_DB
            }
        }

        object HolderAddressUpdateObjectKeyTypeStringValue {
            const val SALESFORCE = "SALESFORCE"
            const val DYNAMO_DB = "DYNAMO_DB"
            const val POSTGRES_DB = "POSTGRES_DB"
        }

        enum class HolderAddressUpdateObjectKeyType {
            SALESFORCE,
            DYNAMO_DB,
            POSTGRES_DB
        }
    }
}