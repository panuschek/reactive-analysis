package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import io.smallrye.mutiny.Multi
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.inject.Singleton

@Singleton
class VehicleConfigurationServiceImpl(
    @RestClient
    private val authenticationService: AuthorizationService,
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
) : VehicleConfigurationService {

    override fun getVehicleConfigurations(authToken: String, countryId: Int): Multi<VehicleConfiguration> {
        return authenticationService
            .auth(authToken)
            .map { it.countryIds }
            .onItem().transformToMulti { authorizedCountries ->
                vehicleConfigurationRepository.findAll(countryId)
                    ?.filter { vehicleConfigurations ->
                        vehicleConfigurations.countryIds.any { it in authorizedCountries }
                    }
            }
    }
}