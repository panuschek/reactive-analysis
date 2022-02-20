package de.pan.springimperative.controller

import de.pan.springimperative.api.entity.VehicleConfiguration
import de.pan.springimperative.api.request.VehicleConfigurationRequest
import de.pan.springimperative.repository.VehicleConfigurationRepository
import de.pan.springimperative.service.MockService
import de.pan.springimperative.service.WebService
import org.springframework.web.bind.annotation.*
import java.time.Duration

@RestController
@RequestMapping("api")
class VehicleConfigurationController(
    private val vehicleConfigurationRepository: VehicleConfigurationRepository,
    private val webService: WebService,
    private val mockService: MockService
) {

    @GetMapping("sleep")
    fun sleep(): String {
        Thread.sleep(150)
        return "ok"
    }

    @GetMapping("apiCall")
    fun apiCall(): String {
        return webService.request()
    }

    @GetMapping("queryDatabase")
    fun queryDatabase(request: VehicleConfigurationRequest): List<VehicleConfiguration> {
        return vehicleConfigurationRepository.findByCountryId(request.countryId!!)
    }

    @PostMapping("chainedCalls")
    fun chainedCalls(@RequestBody request: VehicleConfigurationRequest): List<VehicleConfiguration> {
        mockService.doWork()

        return vehicleConfigurationRepository.findByCountryId(request.countryId!!)
    }
}