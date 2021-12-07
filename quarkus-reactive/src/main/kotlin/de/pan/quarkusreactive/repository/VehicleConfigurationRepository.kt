package de.pan.quarkusreactive.repository

import de.pan.quarkusreactive.api.entity.VehicleConfiguration
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.vertx.mutiny.pgclient.PgPool
import io.vertx.mutiny.sqlclient.Row
import io.vertx.mutiny.sqlclient.Tuple
import javax.inject.Singleton

@Singleton
class VehicleConfigurationRepository(
    private val pgPool: PgPool
) {

    fun findAll(countryId: Int): Uni<List<VehicleConfiguration>> {
        return pgPool.preparedQuery("SELECT * FROM vehicle_configuration WHERE $1 = ANY(country_ids)")
            .execute(Tuple.of(countryId))
            .onItem().transform { row -> row.map { mapRowToVehicleConfiguration(it) } }
            // .onItem().transformToMulti { Multi.createFrom().iterable(it) }
    }

    private fun mapRowToVehicleConfiguration(row: Row): VehicleConfiguration {
        return VehicleConfiguration(
            vehicleConfigurationId = row.getLong("vehicle_configuration_id"),
            createdAt = row.getLong("created_at"),
            model = row.getString("model"),
            countryIds = row.getArrayOfIntegers("country_ids"),
            engineTypes = row.getArrayOfStrings("engine_types"),
            markets = row.getArrayOfStrings("markets"),
            structureVersion = row.getString("structure_version")
        )
    }
}