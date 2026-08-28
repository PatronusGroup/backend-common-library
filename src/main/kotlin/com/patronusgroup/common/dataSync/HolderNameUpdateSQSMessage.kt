package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import java.util.UUID

data class HolderNameUpdateSQSMessage(
    val objectKey: HolderNameUpdateObjectKey,
    val firstName: String,
    val lastName: String
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.HOLDER_NAME_UPDATE

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(HolderNameUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
        JsonSubTypes.Type(HolderNameUpdateObjectKey.DynamoDbKey::class, name = DYNAMO_DB),
        JsonSubTypes.Type(HolderNameUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
    )
    sealed class HolderNameUpdateObjectKey {
        abstract val type: ObjectKeyType

        data class SalesforceKey(val watchUserId: String) : HolderNameUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class DynamoDbKey(val formUuid: UUID) : HolderNameUpdateObjectKey() {
            override val type = ObjectKeyType.DYNAMO_DB
        }

        data class PostgresDbKey(val watchUserId: String) : HolderNameUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}