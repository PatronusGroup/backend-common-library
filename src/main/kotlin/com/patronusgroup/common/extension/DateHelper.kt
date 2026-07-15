package com.patronusgroup.common.extension

import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

fun Date.toLocalDate(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =
    this.toInstant()
        .atZone(zoneId)
        .toLocalDate()