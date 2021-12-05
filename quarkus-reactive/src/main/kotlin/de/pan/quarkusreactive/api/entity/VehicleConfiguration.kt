package de.pan.quarkusreactive.entity

data class VehicleConfiguration(
  var vehicleConfigurationId: Long? = null,
  val createdAt: Long,
  val model: String,
  val countryIds: Array<Int>,
  val engineTypes: Array<String>,
  val markets: Array<String>,
  val structureVersion: String
)
