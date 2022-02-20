package de.pan.quarkusreactive

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import de.pan.quarkusreactive.api.request.VehicleConfigurationRequest
import de.pan.quarkusreactive.repository.VehicleConfigurationRepository
import de.pan.quarkusreactive.service.MockService
import de.pan.quarkusreactive.service.WebService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.time.Duration
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository,
    @RestClient
    private val webService: WebService,
    private val mockService: MockService
) {
    @GET
    @Path("sleep")
    fun sleep(): Uni<String> {
        return Uni.createFrom().item("ok")
            .onItem().delayIt().by(Duration.ofMillis(150))
    }

    @GET
    @Path("apiCall")
    fun apiCall(): Uni<String> {
        return webService.request()
    }

    @POST
    @Path("queryDatabase")
    fun queryDatabase(request: VehicleConfigurationRequest): Multi<VehicleConfiguration> {
        return vehicleConfigurationRepository.findByCountryId(request.countryId!!)
    }

    @GET
    @Path("largeResponse")
    fun chainedCalls(): Multi<Int> {
        return Multi.createFrom().iterable(mockService.getPrimeNumbers().take(1000).asIterable())
    }
}