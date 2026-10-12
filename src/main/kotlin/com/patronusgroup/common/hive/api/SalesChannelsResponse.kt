package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class SalesChannelsResponse (

    @JsonProperty(value = "data")
    val channels: List<SalesChannel> = listOf()
)