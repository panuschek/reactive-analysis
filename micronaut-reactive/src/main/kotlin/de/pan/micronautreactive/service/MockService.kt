package de.pan.micronautreactive.service

import reactor.core.publisher.Mono

interface MockService {
    fun doWork(): Mono<String>
}