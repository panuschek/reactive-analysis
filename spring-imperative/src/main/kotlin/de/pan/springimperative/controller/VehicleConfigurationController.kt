package de.pan.springimperative.controller

import de.pan.springimperative.api.entity.AuthorizationEntitlement
import de.pan.springimperative.api.entity.VehicleConfiguration
import de.pan.springimperative.api.request.VehicleConfigurationRequest
import de.pan.springimperative.repository.AuthenticationService
import de.pan.springimperative.repository.VehicleConfigurationRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository,
    private val authenticationService: AuthenticationService
) {

    private val log = LoggerFactory.getLogger(VehicleConfigurationController::class.java)

    @PostMapping("vehicleconfigurations")
    fun getVehicleConfigurations(@RequestBody request: VehicleConfigurationRequest): AuthorizationEntitlement {
        log.info("Handling request to /api/vehicleconfigurations")
//        return authenticationService.authenticate()
//        return vehicleConfigurationRepository.findByCountryId(request.countryId!!)
        Thread.sleep(1500)
        return AuthorizationEntitlement("Ok")
    }
}