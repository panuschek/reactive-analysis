package de.pan.micronautreactive.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class VehicleConfiguration(
  @field:Id
  @GeneratedValue
  var vehicleConfigurationId: Long? = null,
  val createdAt: Long,
  val model: String,
  val countryIds: Array<Int>,
  val engineTypes: Array<String>,
  val markets: Array<String>,
  val structureVersion: String
)
