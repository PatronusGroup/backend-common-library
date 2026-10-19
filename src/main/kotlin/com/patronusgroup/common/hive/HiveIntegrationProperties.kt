package com.patronusgroup.common.hive

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("common-library-hive-integration")
data class HiveIntegrationProperties(
    var queueName: String = ""
)