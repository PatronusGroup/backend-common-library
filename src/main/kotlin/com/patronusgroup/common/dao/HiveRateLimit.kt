package com.patronusgroup.common.dao

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "hive_rate_limit")
class HiveRateLimit(
    @Id
    val id: Int = SINGLETON_ID,

    @Column(name = "next_slot", nullable = false)
    var nextSlot: Instant = Instant.now(),
) {
    companion object {
        const val SINGLETON_ID = 1
    }
}