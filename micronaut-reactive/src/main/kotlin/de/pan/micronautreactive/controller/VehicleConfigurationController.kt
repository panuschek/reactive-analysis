package de.pan.micronautreactive.controller

import de.pan.micronautreactive.entity.VehicleConfiguration
import de.pan.micronautreactive.repository.VechicleConfigurationRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import reactor.core.publisher.Flux

@Controller("/api")
class VehicleConfigurationController(
  private val vehicleConfigurationRepository: VechicleConfigurationRepository
) {

  @Get("vehicleconfigurations")
  @Produces(MediaType.APPLICATION_JSON)
  fun getVehicleConfigurations(): Flux<VehicleConfiguration> {
    return vehicleConfigurationRepository.findAll()
  }
}