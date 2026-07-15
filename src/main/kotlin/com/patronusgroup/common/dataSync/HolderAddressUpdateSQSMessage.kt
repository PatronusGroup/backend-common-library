package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import java.util.UUID

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
        abstract val type: ObjectKeyType

        data class SalesforceKey(val formUuid: UUID) : HolderAddressUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class DynamoDbKey(val formUuid: UUID) : HolderAddressUpdateObjectKey() {
            override val type = ObjectKeyType.DYNAMO_DB
        }

        data class PostgresDbKey(val watchUserId: String) : HolderAddressUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}

