package de.pan.micronautreactive.service

import de.pan.micronautreactive.api.entity.AuthorizationEntitlement
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher

@Client("http://localhost:8090/api/")
interface AuthenticationService {
    @Get("/authentication")
    fun authenticate(): Publisher<AuthorizationEntitlement>
}