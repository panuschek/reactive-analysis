package de.pan.springimperative.service

import de.pan.springimperative.api.entity.VehicleConfiguration

interface VehicleConfigurationService {
    fun getVehicleConfigurations(authToken: String, countryId: Int): List<VehicleConfiguration>
}