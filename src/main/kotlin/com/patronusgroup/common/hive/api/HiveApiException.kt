package com.patronusgroup.common.hive.api

class HiveApiException(
    val statusCode: Int,
    val responseBody: String,
) : RuntimeException("Hive API error $statusCode: $responseBody")