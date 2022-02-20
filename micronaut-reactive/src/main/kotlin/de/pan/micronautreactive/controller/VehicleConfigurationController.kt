package de.pan.micronautreactive.controller

import de.pan.micronautreactive.api.entity.VehicleConfiguration
import de.pan.micronautreactive.api.request.VehicleConfigurationRequest
import de.pan.micronautreactive.repository.VehicleConfigurationRepository
import de.pan.micronautreactive.service.MockService
import de.pan.micronautreactive.service.WebService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Controller("/api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository,
    private val webService: WebService,
    private val mockService: MockService
) {

  @Get("sleep")
  fun sleep(): Mono<String> {
    return Mono.just("ok")
      .delayElement(Duration.ofMillis(150))
  }

  @Get("apiCall")
  fun apiCall(): Mono<String> {
    return webService.request()
  }

  @Post("queryDatabase")
  fun queryDatabase(request: VehicleConfigurationRequest): Flux<VehicleConfiguration> {
    return vehicleConfigurationRepository.findByCountryId(request.countryId)
  }

  @Post("chainedCalls")
  fun chainedCalls(request: VehicleConfigurationRequest): Flux<VehicleConfiguration> {
    return mockService.doWork()
      .flatMapMany { vehicleConfigurationRepository.findByCountryId(request.countryId) }
  }
}