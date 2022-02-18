package de.pan.micronautreactive.service

import de.pan.micronautreactive.api.entity.VehicleConfiguration
import de.pan.micronautreactive.repository.VehicleConfigurationRepository
import jakarta.inject.Singleton
import reactor.core.publisher.Flux

@Singleton
class VehicleConfigurationServiceImpl (
    private val authenticationService: AuthorizationService,
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
        ) : VehicleConfigurationService {

    override fun getVehicleConfigurations(authToken: String, countryId: Int): Flux<VehicleConfiguration> {
        return authenticationService
            .authorize(authToken)
            .map { it.countryIds }
            .flatMapMany { authorizedCountries ->
                vehicleConfigurationRepository.findByCountryId(countryId)
                    .filter { vehicleConfigurations ->
                        vehicleConfigurations.countryIds.any { it in authorizedCountries }
                    }
            }
    }
}