package de.pan.micronautreactive.controller

import de.pan.micronautreactive.api.entity.AuthorizationEntitlement
import de.pan.micronautreactive.api.entity.VehicleConfiguration
import de.pan.micronautreactive.api.request.VehicleConfigurationRequest
import de.pan.micronautreactive.repository.VechicleConfigurationRepository
import de.pan.micronautreactive.service.AuthenticationService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.time.Duration

@Controller("/api")
class VehicleConfigurationController(
  private val vehicleConfigurationRepository: VechicleConfigurationRepository,
  private val authenticationService: AuthenticationService
) {

  @Post("vehicleconfigurations")
  @Produces(MediaType.APPLICATION_JSON)
  fun getVehicleConfigurations(request: VehicleConfigurationRequest): Mono<AuthorizationEntitlement> {
//    return Mono.just(AuthorizationEntitlement("Ok"))
//      .delayElement(Duration.ofMillis(1500))
    return authenticationService.authenticate().toMono()
  }
}