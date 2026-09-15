package com.patronusgroup.common.repository

import com.patronusgroup.common.dao.HolderDeviceSyncedDeviceInfoDao
import java.util.UUID
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HolderDeviceSyncedDeviceInfoRepository : CrudRepository<HolderDeviceSyncedDeviceInfoDao, UUID> {

    fun findByHolderDeviceId(holderDeviceId: Int): HolderDeviceSyncedDeviceInfoDao?
}