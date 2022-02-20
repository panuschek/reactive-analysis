package de.pan.quarkusreactive.service

import io.smallrye.mutiny.Uni
import java.time.Duration
import javax.inject.Singleton

@Singleton
class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): Uni<String> {
        executionCounter++

        if(executionCounter > 1100) {
            executionCounter = 0
        }

        if(executionCounter > 1000) {
            return Uni.createFrom().item("result")
                .onItem().delayIt().by(Duration.ofMillis(1500))
        }

        return Uni.createFrom().item("result")
    }
}