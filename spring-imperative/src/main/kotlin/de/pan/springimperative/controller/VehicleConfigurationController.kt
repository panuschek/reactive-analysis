package de.pan.springimperative.controller

import de.pan.springimperative.api.entity.VehicleConfiguration
import de.pan.springimperative.api.request.VehicleConfigurationRequest
import de.pan.springimperative.service.AuthorizationService
import de.pan.springimperative.repository.VehicleConfigurationRepository
import de.pan.springimperative.service.VehicleConfigurationService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class VehicleConfigurationController(
    private val vehicleConfigurationService: VehicleConfigurationService
) {
    @PostMapping("vehicleconfigurations")
    fun getVehicleConfigurations(
        @RequestHeader("Authorization") authToken: String,
        @RequestBody request: VehicleConfigurationRequest
    ): List<VehicleConfiguration> {
        return vehicleConfigurationService.getVehicleConfigurations(authToken, request.countryId!!)
    }
}