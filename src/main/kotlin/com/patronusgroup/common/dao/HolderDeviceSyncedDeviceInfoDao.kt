package com.patronusgroup.common.dao

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID
import kotlin.jvm.javaClass

@Entity
@Table( name = "holder_device_synced_device_info")
class HolderDeviceSyncedDeviceInfoDao(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hdsdi_uuid")
    var hdsdiUuid: UUID? = null,

    @Column(name = "holder_device_id")
    var holderDeviceId: Int = 0,

    @Column(name = "is_wifi_connected", nullable = false)
    var isWifiConnected: Boolean = false,

    @Column(name = "synced_on")
    var syncedOn: LocalDateTime? = LocalDateTime.now()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HolderDeviceSyncedDeviceInfoDao

        if (holderDeviceId != other.holderDeviceId) return false
        if (isWifiConnected != other.isWifiConnected) return false
        if (hdsdiUuid != other.hdsdiUuid) return false
        if (syncedOn != other.syncedOn) return false

        return true
    }

    override fun hashCode(): Int {
        var result = holderDeviceId
        result = 31 * result + isWifiConnected.hashCode()
        result = 31 * result + (hdsdiUuid?.hashCode() ?: 0)
        result = 31 * result + (syncedOn?.hashCode() ?: 0)
        return result
    }
}
