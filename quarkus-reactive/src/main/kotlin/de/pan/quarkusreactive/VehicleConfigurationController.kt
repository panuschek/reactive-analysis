package de.pan.quarkusreactive

import de.pan.quarkusreactive.api.entity.AuthorizationEntitlement
import de.pan.quarkusreactive.api.request.VehicleConfigurationRequest
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import de.pan.quarkusreactive.service.AuthenticationService
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.time.Duration
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository,
    @RestClient
    private val authenticationService: AuthenticationService
) {
    @POST
    @Path("vehicleconfigurations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun vehicleConfigurations(request: VehicleConfigurationRequest): Uni<AuthorizationEntitlement> {
        return authenticationService.authenticate()

//        return Uni.combine().all()
//            .unis(authenticationService.authenticate(), vehicleConfigurationRepository.findAll(request.countryId!!))
//            .combinedWith { t, u -> u }
//            .onItem().transformToMulti { Multi.createFrom().iterable(it) }

//         return Uni.createFrom()
//             .item(AuthorizationEntitlement("Ok"))
//             .onItem()
//             .delayIt()
//             .by(Duration.ofMillis(1500))
    }
}