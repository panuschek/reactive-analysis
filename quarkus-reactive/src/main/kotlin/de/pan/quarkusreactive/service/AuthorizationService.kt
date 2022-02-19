package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.AuthToken
import de.pan.quarkusreactive.api.entity.AuthorizationEntitlement
import io.smallrye.mutiny.Uni
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.mutiny.core.Vertx
import io.vertx.mutiny.ext.web.client.HttpResponse
import io.vertx.mutiny.ext.web.client.WebClient
import io.vertx.mutiny.ext.web.client.WebClientSession
import kotlinx.coroutines.awaitAll
import javax.inject.Singleton

//@Path("/auth")
//@RegisterRestClient(configKey = "authentication-api")
//interface AuthorizationService {
//    @GET
//    fun auth(@HeaderParam("Authorization") authToken: String): Uni<AuthorizationEntitlement>
//}

@Singleton
class AuthorizationService(private val vertx: Vertx) {
    private val client: WebClient
    private val authTokens: MutableMap<String, AuthToken>

    init {
        this.client = WebClient.create(vertx)
        authTokens = mutableMapOf()
    }

    fun auth(userId: String, authToken: String): Uni<AuthorizationEntitlement> {
        if(authTokens.containsKey(userId) && authTokens[userId]!!.expiresAt > System.currentTimeMillis())
            return Uni.createFrom().item(AuthorizationEntitlement(authTokens[userId]!!.countryIds))

        return client.getAbs("http://192.168.178.26:8090/api/auth")
            .putHeader("Authorization", authToken)
            .send()
            .onItem().transform {
                val token = it.bodyAsJson(AuthorizationEntitlement::class.java)
                authTokens[userId] = AuthToken(System.currentTimeMillis() + 5000, token.countryIds)
                return@transform token
            }
    }
}