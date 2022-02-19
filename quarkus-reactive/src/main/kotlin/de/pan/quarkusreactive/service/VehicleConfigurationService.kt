package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import io.smallrye.mutiny.Uni

interface VehicleConfigurationService {
    fun getVehicleConfigurations(userId: String, authToken: String, countryId: Int): Uni<List<VehicleConfiguration>>
}