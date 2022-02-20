package de.pan.micronautreactive.service

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client("\${webservice.url}/api")
interface WebService {
    @Get("/dummy")
    fun request(): Mono<String>
}