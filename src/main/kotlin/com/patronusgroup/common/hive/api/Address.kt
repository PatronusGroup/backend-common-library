package com.patronusgroup.common.hive.api

import com.fasterxml.jackson.annotation.JsonProperty

data class Address(

    @JsonProperty("city")
    val city: String,

    @JsonProperty("country_code")
    val countryCode: String,

    @JsonProperty("postal_code")
    val postalCode: String,

    @JsonProperty("line1")
    val street: String,

    @JsonProperty("first_name")
    val firstName: String?,

    @JsonProperty("last_name")
    val lastName: String?,

    @JsonProperty("full_name")
    val fullName: String?,

    @JsonProperty("email")
    val email: String?,

    @JsonProperty("phone")
    val phone: String?
)
