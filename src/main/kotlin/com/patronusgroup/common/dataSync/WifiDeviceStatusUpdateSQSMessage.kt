package com.patronusgroup.common.dataSync

import java.util.UUID

data class WifiDeviceStatusUpdateSQSMessage(
    val wifiConnected: Boolean,
    val holderUuid: UUID,
    val wifiDeviceId: Int?
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.WIFI_DEVICE_STATUS_UPDATE
}