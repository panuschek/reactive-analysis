package de.pan.micronautreactive.controller

import de.pan.micronautreactive.api.entity.AuthorizationEntitlement
import de.pan.micronautreactive.api.entity.VehicleConfiguration
import de.pan.micronautreactive.api.request.VehicleConfigurationRequest
import de.pan.micronautreactive.repository.VehicleConfigurationRepository
import de.pan.micronautreactive.service.AuthorizationService
import de.pan.micronautreactive.service.VehicleConfigurationService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Controller("/api")
class VehicleConfigurationController(
  private val vehicleConfigurationRepository: VehicleConfigurationRepository,
  private val authenticationService: AuthorizationService,
  private val vehicleConfigurationService: VehicleConfigurationService
) {

//  @Get("sleep")
//  fun sleep(): Mono<String> {
//    return Mono.just("ok")
//      .delayElement(Duration.ofMillis(20))
//  }
//
//  @Get("apiCall")
//  fun apiCall(): Mono<AuthorizationEntitlement> {
//    return authenticationService.authenticate()
//  }
//
//  @Get("queryDatabase")
//  fun queryDatabase(countryId: Int): Flux<VehicleConfiguration> {
//    return vehicleConfigurationRepository.findByCountryId(countryId)
//  }

  @Post("vehicleconfigurations")
  @Produces(MediaType.APPLICATION_JSON)
  fun getVehicleConfigurations(@Header("Authorization") authToken: String, request: VehicleConfigurationRequest): Flux<VehicleConfiguration> {
    return vehicleConfigurationService.getVehicleConfigurations(authToken, request.countryId)
  }
}