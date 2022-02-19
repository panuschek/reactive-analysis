package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.AuthorizationEntitlement
import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.time.Duration
import java.util.logging.Logger
import javax.inject.Singleton

@Singleton
class VehicleConfigurationServiceImpl(
    private val authenticationService: AuthorizationService,
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
) : VehicleConfigurationService {

    private var authorizationEntitlement: AuthorizationEntitlement

    override fun getVehicleConfigurations(userId: String, authToken: String, countryId: Int): Uni<List<VehicleConfiguration>> {
        return Uni.combine().all()
            .unis(authenticationService.auth(userId, authToken), vehicleConfigurationRepository.findAll(countryId))
            .combinedWith { entitlement, vehicleConfigurations ->
                vehicleConfigurations.filter { vehicleConfiguration ->
                    vehicleConfiguration.countryIds.any { it in entitlement.countryIds }
                }
            }

//        return Uni.combine().all()
//            .unis(Uni.createFrom().item(authorizationEntitlement).onItem().delayIt().by(Duration.ofMillis(5000)), vehicleConfigurationRepository.findAll(countryId))
//            .combinedWith { entitlement, vehicleConfigurations ->
//                vehicleConfigurations.filter { vehicleConfiguration ->
//                    vehicleConfiguration.countryIds.any { it in entitlement.countryIds }
//                }
//            }
    }

    init {
        authorizationEntitlement = AuthorizationEntitlement(arrayOf(1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            29,
            40,
            41,
            42,
            43,
            44,
            45,
            46,
            47,
            48,
            49,
            50,
            51,
            52,
            53,
            54,
            55,
            56,
            57,
            58,
            59,
            70,
            71,
            72,
            73,
            74,
            75,
            76,
            77,
            78,
            79,
            90,
            91,
            92,
            93,
            94,
            95,
            96,
            97,
            98,
            99))
    }
}