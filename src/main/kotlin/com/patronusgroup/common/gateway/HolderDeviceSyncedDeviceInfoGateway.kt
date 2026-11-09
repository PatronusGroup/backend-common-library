package com.patronusgroup.common.gateway

import com.patronusgroup.common.config.ConditionalProperties
import com.patronusgroup.common.entity.HolderDeviceSyncedDeviceInfo
import com.patronusgroup.common.repository.HolderDeviceSyncedDeviceInfoRepository
import java.time.LocalDateTime
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@ConditionalOnProperty(
    ConditionalProperties.PERSISTENCE_LAYER,
    havingValue = "true",
    matchIfMissing = true
)
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