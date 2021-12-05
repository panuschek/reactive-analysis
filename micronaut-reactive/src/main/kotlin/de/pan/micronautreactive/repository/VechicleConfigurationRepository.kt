package de.pan.micronautreactive.repository

import de.pan.micronautreactive.api.entity.VehicleConfiguration
import io.micronaut.data.annotation.Query
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import reactor.core.publisher.Flux

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface VechicleConfigurationRepository : ReactiveStreamsCrudRepository<VehicleConfiguration, Long> {
  override fun findAll(): Flux<VehicleConfiguration>

  @Query("SELECT * FROM vehicle_configuration WHERE :countryId = ANY (country_ids)")
  fun findByCountryIdsIn(countryId: Int): Flux<VehicleConfiguration>
}