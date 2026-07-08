package com.patronusgroup.common.domain.healthData

import com.patronusgroup.common.domain.enum.Mode

data class KeyBox(
    val hasKeyBox: Boolean?,
    val keyBoxCode: String?,
    val keyBoxLocation: String?,
    val mode: Mode?
)