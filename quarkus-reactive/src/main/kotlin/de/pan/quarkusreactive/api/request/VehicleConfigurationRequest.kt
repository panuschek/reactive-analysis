package de.pan.quarkusreactive.api.request

import com.fasterxml.jackson.annotation.JsonProperty

data class VehicleConfigurationRequest(
    @field:JsonProperty("countryId")
    val countryId: Int? = 0
)