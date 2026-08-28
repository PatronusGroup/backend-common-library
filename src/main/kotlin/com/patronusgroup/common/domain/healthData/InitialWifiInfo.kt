package com.patronusgroup.common.domain.healthData

data class InitialWifiInfo(
    val networkName: String,
    val password: String? = null,
    val securityProtocol: String,
    val wifiLocation: String
)