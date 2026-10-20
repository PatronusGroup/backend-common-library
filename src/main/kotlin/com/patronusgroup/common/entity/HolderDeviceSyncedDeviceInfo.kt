package com.patronusgroup.common.entity

import com.patronusgroup.common.dao.HolderDeviceSyncedDeviceInfoDao
import java.time.LocalDateTime
import java.util.UUID

data class HolderDeviceSyncedDeviceInfo(
    var hdsdiUuid: UUID? = null,
    var holderDeviceId: Int = 0,
    var isWifiConnected: Boolean = false,
    var syncedOn: LocalDateTime? = null
){
    fun toDao(): HolderDeviceSyncedDeviceInfoDao = HolderDeviceSyncedDeviceInfoDao(
        hdsdiUuid = hdsdiUuid,
        holderDeviceId = holderDeviceId,
        isWifiConnected = isWifiConnected,
        syncedOn = LocalDateTime.now()
    )

    companion object {

        fun fromDao(dao: HolderDeviceSyncedDeviceInfoDao): HolderDeviceSyncedDeviceInfo {
            return HolderDeviceSyncedDeviceInfo(
                hdsdiUuid = dao.hdsdiUuid,
                holderDeviceId = dao.holderDeviceId,
                isWifiConnected = dao.isWifiConnected,
                syncedOn = dao.syncedOn
            )
        }
    }
}
