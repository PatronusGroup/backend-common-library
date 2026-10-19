package com.patronusgroup.common.repository

import com.patronusgroup.common.dao.HiveRateLimit
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface HiveRateLimitRepository : JpaRepository<HiveRateLimit, Int> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select r from HiveRateLimit r where r.id = :id")
    fun findForUpdate(@Param("id") id: Int): HiveRateLimit?
}