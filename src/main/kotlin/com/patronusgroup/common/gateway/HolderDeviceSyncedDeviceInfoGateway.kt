package com.patronusgroup.common.gateway

import com.patronusgroup.common.entity.HolderDeviceSyncedDeviceInfo
import com.patronusgroup.common.repository.HolderDeviceSyncedDeviceInfoRepository
import org.springframework.stereotype.Service

@Service
class HolderDeviceSyncedDeviceInfoGateway(
    private val holderDeviceSyncedDeviceInfoRepository: HolderDeviceSyncedDeviceInfoRepository
) {
    fun findByHolderDeviceId(holderDeviceId: Int): HolderDeviceSyncedDeviceInfo? {
        return holderDeviceSyncedDeviceInfoRepository.findByHolderDeviceId(holderDeviceId)?.let {
            HolderDeviceSyncedDeviceInfo.fromDao(it)
        }
    }
}