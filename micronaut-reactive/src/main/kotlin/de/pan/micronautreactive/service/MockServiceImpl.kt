package de.pan.micronautreactive.service

import jakarta.inject.Singleton
import reactor.core.publisher.Mono
import java.time.Duration

@Singleton
class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): Mono<String> {
        executionCounter++

        if(executionCounter > 1100) {
            executionCounter = 0
        }

        if(executionCounter >= 1000) {
            return Mono.just("result")
                .delayElement(Duration.ofMillis(1500))
        }

        return Mono.just("result")
    }
}