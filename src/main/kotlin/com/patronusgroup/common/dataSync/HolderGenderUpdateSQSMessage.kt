package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import com.patronusgroup.common.domain.enum.Gender
import java.util.UUID

data class HolderGenderUpdateSQSMessage(
    val objectKey: HolderGenderUpdateObjectKey,
    val gender: Gender
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.HOLDER_GENDER_UPDATE

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(HolderGenderUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
        JsonSubTypes.Type(HolderGenderUpdateObjectKey.DynamoDbKey::class, name = DYNAMO_DB),
        JsonSubTypes.Type(HolderGenderUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
    )
    sealed class HolderGenderUpdateObjectKey {
        abstract val type: ObjectKeyType

        data class SalesforceKey(val watchUserId: String) : HolderGenderUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class DynamoDbKey(val formUuid: UUID) : HolderGenderUpdateObjectKey() {
            override val type = ObjectKeyType.DYNAMO_DB
        }

        data class PostgresDbKey(val watchUserId: String) : HolderGenderUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}