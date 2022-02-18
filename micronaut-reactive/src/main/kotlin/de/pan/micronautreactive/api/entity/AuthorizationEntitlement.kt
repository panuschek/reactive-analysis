package de.pan.micronautreactive.api.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorizationEntitlement(
    val countryIds: Array<Int>
)
