package de.pan.micronautreactive.repository

import de.pan.micronautreactive.entity.VehicleConfiguration
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import reactor.core.publisher.Flux

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface VechicleConfigurationRepository : ReactiveStreamsCrudRepository<VehicleConfiguration, Long> {
  override fun findAll(): Flux<VehicleConfiguration>
}