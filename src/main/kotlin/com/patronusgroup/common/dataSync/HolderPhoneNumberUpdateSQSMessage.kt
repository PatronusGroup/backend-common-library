package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.DYNAMO_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import java.util.UUID

class HolderPhoneNumberUpdateSQSMessage(
    val objectKey: HolderPhoneNumberUpdateObjectKey,
    val phoneNumber: String
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.HOLDER_PHONE_NUMBER_UPDATE

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(HolderPhoneNumberUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
        JsonSubTypes.Type(HolderPhoneNumberUpdateObjectKey.DynamoDbKey::class, name = DYNAMO_DB),
        JsonSubTypes.Type(HolderPhoneNumberUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
    )
    sealed class HolderPhoneNumberUpdateObjectKey {
        abstract val type: ObjectKeyType

        data class SalesforceKey(val watchUserId: String) : HolderPhoneNumberUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class DynamoDbKey(val formUuid: UUID) : HolderPhoneNumberUpdateObjectKey() {
            override val type = ObjectKeyType.DYNAMO_DB
        }

        data class PostgresDbKey(val watchUserId: String) : HolderPhoneNumberUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}