package de.pan.micronautreactive.service

import reactor.core.publisher.Mono
import java.time.Duration

class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): Mono<String> {
        executionCounter++

        if(executionCounter in 1001..1099) {
            return Mono.just("result")
                .delayElement(Duration.ofMillis(1500))
        }

        return Mono.just("result")
    }
}