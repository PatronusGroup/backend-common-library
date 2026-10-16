package com.patronusgroup.common.hive.api

enum class HiveErrorType {
    ALREADY_EXISTS,
    RATE_LIMITED,
    RETRYABLE,
    AUTH,
    PERMANENT
}

fun HiveApiException.type(): HiveErrorType = when (statusCode) {
    409 -> HiveErrorType.ALREADY_EXISTS
    429 -> HiveErrorType.RATE_LIMITED
    401, 403 -> HiveErrorType.AUTH
    400, 422 -> HiveErrorType.PERMANENT
    408, 999, in 500..599 -> HiveErrorType.RETRYABLE
    else -> HiveErrorType.PERMANENT
}