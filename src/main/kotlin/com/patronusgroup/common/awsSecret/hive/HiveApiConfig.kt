package com.patronusgroup.common.awsSecret.hive

data class HiveApiConfig(
    val token: String,
    val webhookProcessingChannels: List<HiveChannel>
) {
    data class HiveChannel(
        val channelId: Int,
        val defaultApiChannel: Boolean
    )
}