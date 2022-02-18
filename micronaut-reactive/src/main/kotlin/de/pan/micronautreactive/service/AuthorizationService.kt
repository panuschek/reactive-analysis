package de.pan.micronautreactive.service

import de.pan.micronautreactive.api.entity.AuthorizationEntitlement
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client("http://localhost:8090/api/")
interface AuthorizationService {
    @Get("/auth")
    fun authorize(@Header(name = "Authorization") authorization: String): Mono<AuthorizationEntitlement>
}