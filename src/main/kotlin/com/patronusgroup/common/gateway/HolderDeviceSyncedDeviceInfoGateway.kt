package com.patronusgroup.common.gateway

import com.patronusgroup.common.entity.HolderDeviceSyncedDeviceInfo
import com.patronusgroup.common.repository.HolderDeviceSyncedDeviceInfoRepository
import java.time.LocalDateTime
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HolderDeviceSyncedDeviceInfoGateway(
    private val holderDeviceSyncedDeviceInfoRepository: HolderDeviceSyncedDeviceInfoRepository
) {
    fun findByHolderDeviceId(holderDeviceId: Int): HolderDeviceSyncedDeviceInfo? {
        return holderDeviceSyncedDeviceInfoRepository.findByHolderDeviceId(holderDeviceId)?.let {
            HolderDeviceSyncedDeviceInfo.fromDao(it)
        }
    }

    @Transactional
    fun saveOrUpdate(holderDeviceId: Int, isWifiConnected: Boolean) {

        val existing = findByHolderDeviceId(holderDeviceId)

        val entity = existing?.copy(
            isWifiConnected = isWifiConnected,
            syncedOn = LocalDateTime.now()
        )
            ?: HolderDeviceSyncedDeviceInfo(
                holderDeviceId = holderDeviceId,
                isWifiConnected = isWifiConnected,
                syncedOn = LocalDateTime.now()
            )

        holderDeviceSyncedDeviceInfoRepository.save(entity.toDao())
    }
}