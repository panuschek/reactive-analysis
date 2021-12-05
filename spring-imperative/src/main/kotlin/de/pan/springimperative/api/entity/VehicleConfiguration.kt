package de.pan.springimperative.api.entity

import org.springframework.data.annotation.Id

data class VehicleConfiguration(
  @Id
  var vehicleConfigurationId: Long? = null,
  val createdAt: Long,
  val model: String,
  val countryIds: Array<Int>,
  val engineTypes: Array<String>,
  val markets: Array<String>,
  val structureVersion: String
)