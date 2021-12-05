package de.pan.authenticationservice

data class AuthorizationEntitlement(
    val country_ids: List<Int>,
    val markets: List<String>
)
