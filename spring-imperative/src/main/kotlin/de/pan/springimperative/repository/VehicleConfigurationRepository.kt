package de.pan.springimperative.repository

import de.pan.springimperative.api.entity.VehicleConfiguration
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface VehicleConfigurationRepository : CrudRepository<VehicleConfiguration, Long> {
    override fun findAll(): List<VehicleConfiguration>
    @Query("SELECT * FROM vehicle_configuration WHERE :countryId = ANY(country_ids)")
    fun findByCountryId(countryId: Int): List<VehicleConfiguration>
}