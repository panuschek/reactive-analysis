package de.pan.quarkusreactive.service

import javax.inject.Singleton

@Singleton
class MockServiceImpl : MockService {
    override fun getPrimeNumbers(): Sequence<Int> {
        var i = 0

        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0 }) }
                .forEach { yield(it) }
        }
    }
}