package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import io.smallrye.mutiny.Multi

interface VehicleConfigurationService {
    fun getVehicleConfigurations(authToken: String, countryId: Int): Multi<VehicleConfiguration>
}