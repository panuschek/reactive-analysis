package de.pan.micronautreactive.controller

import de.pan.micronautreactive.api.entity.VehicleConfiguration
import de.pan.micronautreactive.api.request.VehicleConfigurationRequest
import de.pan.micronautreactive.repository.VechicleConfigurationRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import reactor.core.publisher.Flux

@Controller("/api")
class VehicleConfigurationController(
  private val vehicleConfigurationRepository: VechicleConfigurationRepository
) {

  @Post("vehicleconfigurations")
  @Produces(MediaType.APPLICATION_JSON)
  fun getVehicleConfigurations(request: VehicleConfigurationRequest): Flux<VehicleConfiguration> {
    return vehicleConfigurationRepository.findByCountryIdsIn(request.countryId)
  }
}