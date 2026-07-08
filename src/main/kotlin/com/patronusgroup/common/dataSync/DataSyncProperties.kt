package com.patronusgroup.common.dataSync

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("common-library-data-sync")
data class DataSyncProperties(
    var queueName: String = ""
)