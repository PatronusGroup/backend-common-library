package com.patronusgroup.common.dateFormatter

import java.time.format.DateTimeFormatter

object DateFormats {
    val ISO_LOCAL_DATE: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
}