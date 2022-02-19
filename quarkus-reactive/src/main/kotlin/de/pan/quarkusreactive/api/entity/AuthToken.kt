package de.pan.quarkusreactive.api.entity

data class AuthToken(
    val expiresAt: Long,
    val countryIds: Array<Int>
)
