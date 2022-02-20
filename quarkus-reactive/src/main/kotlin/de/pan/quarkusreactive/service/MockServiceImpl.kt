package de.pan.quarkusreactive.service

import io.smallrye.mutiny.Uni
import java.time.Duration

class MockServiceImpl : MockService {
    private var executionCounter = 0

    override fun doWork(): Uni<String> {
        executionCounter++

        if(executionCounter in 1001..1099) {
            return Uni.createFrom().item("result")
                .onItem().delayIt().by(Duration.ofMillis(1500))
        }

        return Uni.createFrom().item("result")
    }
}