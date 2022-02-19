package de.pan.quarkusreactive

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.api.request.VehicleConfigurationRequest
import de.pan.quarkusreactive.service.VehicleConfigurationService
import io.smallrye.mutiny.Uni
import org.jboss.resteasy.reactive.RestHeader
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api")
class VehicleConfigurationController(
    private val vehicleConfigurationService: VehicleConfigurationService
) {
    @POST
    @Path("vehicleconfigurations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun vehicleConfigurations(
        @RestHeader("Authorization") authToken: String,
        @RestHeader("UserId") userId: String,
        request: VehicleConfigurationRequest
    ): Uni<List<VehicleConfiguration>> {
        return vehicleConfigurationService.getVehicleConfigurations(userId, authToken, request.countryId!!)
    }

//    @GET
//    @Path("vehicleconfigurations")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    fun vehicleConfigurations(): Uni<AuthorizationEntitlement>? {
////        return authenticationService.authenticate()
////        return vehicleConfigurationRepository.findAll(request.countryId!!)
////        return Uni.combine().all()
////            .unis(authenticationService.authenticate(), vehicleConfigurationRepository.findAll(request.countryId!!))
////            .combinedWith { t, u -> u }
////            .onItem().transformToMulti { Multi.createFrom().iterable(it) }
//
//        return Uni.createFrom()
//            .item(AuthorizationEntitlement("Ok"))
//            .onItem()
//            .delayIt()
//            .by(Duration.ofMillis(1500))
//    }
}