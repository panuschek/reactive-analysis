package de.pan.quarkusreactive

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import io.smallrye.mutiny.Multi
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ReactiveGreetingResource(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun vehicleConfigurations(): Multi<VehicleConfiguration> {
        return vehicleConfigurationRepository.findAll()
    }
}