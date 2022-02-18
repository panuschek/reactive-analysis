package de.pan.springimperative.service

import de.pan.springimperative.api.entity.VehicleConfiguration
import de.pan.springimperative.repository.VehicleConfigurationRepository
import org.springframework.stereotype.Service

@Service
class VehicleConfigurationServiceImpl(
    private val authenticationService: AuthorizationService,
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
) : VehicleConfigurationService {

    override fun getVehicleConfigurations(authToken: String, countryId: Int): List<VehicleConfiguration> {
        val authorizedCountries = authenticationService.auth(authToken).countryIds

        return vehicleConfigurationRepository.findByCountryId(countryId)
            .filter { it.countryIds.any { it in authorizedCountries } }
    }
}