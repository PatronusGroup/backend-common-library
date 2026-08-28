package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import java.time.LocalDate
import java.util.UUID

data class HolderBirthdayUpdateSQSMessage(
    val objectKey: HolderBirthdayUpdateObjectKey,
    val birthday: LocalDate
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.HOLDER_BIRTHDAY_UPDATE

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(HolderBirthdayUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
        JsonSubTypes.Type(HolderBirthdayUpdateObjectKey.DynamoDbKey::class, name = DYNAMO_DB),
        JsonSubTypes.Type(HolderBirthdayUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
    )
    sealed class HolderBirthdayUpdateObjectKey {
        abstract val type: ObjectKeyType

        data class SalesforceKey(val watchUserId: String) : HolderBirthdayUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class DynamoDbKey(val formUuid: UUID) : HolderBirthdayUpdateObjectKey() {
            override val type = ObjectKeyType.DYNAMO_DB
        }

        data class PostgresDbKey(val watchUserId: String) : HolderBirthdayUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}