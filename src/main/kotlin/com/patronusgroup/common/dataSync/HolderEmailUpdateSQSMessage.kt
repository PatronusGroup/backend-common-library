package com.patronusgroup.common.dataSync

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.POSTGRES_DB
import com.patronusgroup.common.dataSync.DataSyncSQSMessage.ObjectKeyTypeStringValue.SALESFORCE
import java.util.UUID

data class HolderEmailUpdateSQSMessage(
    val objectKey: HolderEmailUpdateObjectKey,
    val holderUuid: UUID,
    val email: String,
    val previousEmail: String? = null
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.HOLDER_EMAIL_UPDATE

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(HolderEmailUpdateObjectKey.SalesforceKey::class, name = SALESFORCE),
        JsonSubTypes.Type(HolderEmailUpdateObjectKey.PostgresDbKey::class, name = POSTGRES_DB),
    )
    sealed class HolderEmailUpdateObjectKey {

        @get:JsonIgnore
        abstract val type: ObjectKeyType

        data class SalesforceKey(val watchUserId: String) : HolderEmailUpdateObjectKey() {
            override val type = ObjectKeyType.SALESFORCE
        }

        data class PostgresDbKey(val watchUserId: String) : HolderEmailUpdateObjectKey() {
            override val type = ObjectKeyType.POSTGRES_DB
        }
    }
}
