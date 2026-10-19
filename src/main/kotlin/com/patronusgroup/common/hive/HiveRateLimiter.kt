package com.patronusgroup.common.hive

import java.time.Clock
import java.time.Duration
import org.springframework.stereotype.Component

@Component
class HiveRateLimiter(
    private val reservationService: HiveSlotReservationService,
    private val clock: Clock,
) {

    fun acquire(maxWait: Duration = Duration.ofSeconds(30)) {
        val slot = reservationService.reserveSlot(maxWait)   // transaction commits here
        val waitMs = Duration.between(clock.instant(), slot).toMillis()
        if (waitMs > 0) Thread.sleep(waitMs)
    }
}