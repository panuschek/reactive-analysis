package de.pan.micronautreactive.service

import de.pan.micronautreactive.api.entity.VehicleConfiguration
import reactor.core.publisher.Flux

interface VehicleConfigurationService {
    fun getVehicleConfigurations(authToken: String, countryId: Int): Flux<VehicleConfiguration>
}