package com.patronusgroup.common.hive.api.gateway

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "hive.api")
data class HiveApiProperties(
    val scheme: String,
    val host: String,
    val url: String,
    val configSecret: String
)