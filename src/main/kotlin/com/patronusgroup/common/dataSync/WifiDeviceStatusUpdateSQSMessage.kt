package com.patronusgroup.common.dataSync

data class WifiDeviceStatusUpdateSQSMessage(
    val holderDeviceId: Int,
    val wifiConnected: Boolean
) : DataSyncSQSMessage() {

    override val type = DataSyncSQSMessageType.WIFI_DEVICE_STATUS_UPDATE
}