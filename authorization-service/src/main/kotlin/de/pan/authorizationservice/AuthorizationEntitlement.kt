package de.pan.authorizationservice

data class AuthorizationEntitlement(
    val country_ids: List<Int>,
    val markets: List<String>
)
