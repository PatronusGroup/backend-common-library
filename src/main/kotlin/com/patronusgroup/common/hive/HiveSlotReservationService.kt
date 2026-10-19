package com.patronusgroup.common.hive

import com.patronusgroup.common.dao.HiveRateLimit
import com.patronusgroup.common.repository.HiveRateLimitRepository
import java.time.Clock
import java.time.Duration
import java.time.Instant
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HiveSlotReservationService(
    private val repository: HiveRateLimitRepository,
    private val clock: Clock,
    @Value("\${common-library-hive-integration.rate-limit-interval-ms:750}")
    private val intervalMs: Long,
) {

    /**
     * Reserves the next free time slot and returns when the caller may call Hive.
     * Throws if the slot is further away than maxWait; nothing is reserved in that case.
     */
    @Transactional
    fun reserveSlot(maxWait: Duration): Instant {
        val now = clock.instant()
        val row = repository.findForUpdate(HiveRateLimit.SINGLETON_ID)
            ?: error("hive_rate_limit row missing, check the migration")

        val slot = maxOf(row.nextSlot, now)
        if (Duration.between(now, slot) > maxWait) {
            throw HiveRateLimitWaitTimeoutException()
        }

        row.nextSlot = slot.plusMillis(intervalMs)
        return slot
    }

    class HiveRateLimitWaitTimeoutException : RuntimeException("Timed out waiting for a Hive rate limit slot")
}