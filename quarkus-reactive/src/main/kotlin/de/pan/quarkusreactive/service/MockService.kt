package de.pan.quarkusreactive.service

import io.smallrye.mutiny.Uni

interface MockService {
    fun doWork(): Uni<String>
}