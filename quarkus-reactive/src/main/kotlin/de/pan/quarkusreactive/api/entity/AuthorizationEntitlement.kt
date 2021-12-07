package de.pan.quarkusreactive.api.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorizationEntitlement(
    @JsonProperty("body")
    val body: String
)
