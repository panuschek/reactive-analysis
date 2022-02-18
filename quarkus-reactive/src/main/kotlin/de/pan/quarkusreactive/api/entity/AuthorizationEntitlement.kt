package de.pan.quarkusreactive.api.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorizationEntitlement(
    @JsonProperty("countryIds")
    val countryIds: Array<Int>
)
