package de.pan.quarkusreactive

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.api.request.VehicleConfigurationRequest
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import io.smallrye.mutiny.Multi
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository
) {

    @POST
    @Path("vehicleconfigurations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun vehicleConfigurations(request: VehicleConfigurationRequest): Multi<VehicleConfiguration> {
        return vehicleConfigurationRepository.findAll(request.countryId!!)
    }
}